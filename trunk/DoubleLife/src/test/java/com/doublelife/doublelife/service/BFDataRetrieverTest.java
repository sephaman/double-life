/**
 * 
 */
package com.doublelife.doublelife.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.retrievedBetData.InflatedMarketPrices;
import com.doublelife.doublelife.data.BetComp.retrievedBetData.InflatedMarketPrices.InflatedRunner;
import com.doublelife.doublelife.data.dao.UserBettingDAO;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.ArrayOfInt;
import com.doublelife.doublelife.services.impl.BFBetDataRetrieverServiceImpl;

/**
 * @author Joseph McAleer
 *
 */
@ContextConfiguration(locations = { "/servlet-context-TEST.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BFDataRetrieverTest {

	@Autowired
	private UserBettingDAO userBettingDAO;
	
	private BFBetDataRetrieverServiceImpl service = new BFBetDataRetrieverServiceImpl();
	
	private final Logger logger = LoggerFactory.getLogger(BFDataRetrieverTest.class);
	
	/**
	 * Test method for {@link com.doublelife.doublelife.services.impl.BFBetDataRetrieverServiceImpl#login()}.
	 */
	@Test
	public void testLogin() throws Exception {
		service.login();
		service.logout();
	}
	
	@Test
	public void testGetMarketPrices() throws Exception {
		service.login();
		InflatedMarketPrices prices = service.getMarketPrices(100494819);//244667
		service.logout();
	}
	
	@Test
	public void testGetMarket() throws Exception {
		service.login();
		service.getMarketData(100399461);//244667
		service.logout();
	}
	
	@Test
	public void testGetAllMarketsData() throws Exception {
		service.login();
		service.getAllMarketsData();
		service.logout();
	}
	
	@Test
	public void testGetAllEvents() throws Exception {
		service.login();
		service.getAllEventsData();
		service.logout();
	}
	
	@Test
	public void testGetAllAFLMarketsData() throws Exception {
		service.login();
		ArrayOfInt arrInt = new ArrayOfInt();
		int[] nums = new int[1];
		nums[0] = 61420;
		arrInt.set_int(nums);
		String resp = service.getAllMarketsData(arrInt);
		List<Integer> lstMatchIds = service.getAllMatchIdsForMatchOdds(resp);
		
		List<InflatedMarketPrices> allPrices = new ArrayList<InflatedMarketPrices>();
		for (Integer thisMarketId : lstMatchIds) {
			allPrices.add(service.getMarketPrices(thisMarketId));
		}
		
		for (InflatedMarketPrices thisMarketPrice : allPrices) {
			logger.info("Market Prices: " + thisMarketPrice.getMarketId() + " Runner 1:" 
		+ thisMarketPrice.getRunners().get(0).getSelectionId() + " - " + thisMarketPrice.getRunners().get(0).getLastPriceMatched() + " Runner 2:" 
				+ thisMarketPrice.getRunners().get(1).getSelectionId() + " - " + thisMarketPrice.getRunners().get(1).getLastPriceMatched());
		}
		
		service.logout();
		
	}
	
	@Test
	public void testGetPricesForRound() throws Exception {
		service.login();
		ArrayOfInt arrInt = new ArrayOfInt();
		int[] nums = new int[1];
		nums[0] = 61420;
		arrInt.set_int(nums);
		String resp = service.getAllMarketsData(arrInt);
		List<Integer> lstMatchIds = service.getAllMatchIdsForMatchOdds(resp);
		
		List<InflatedMarketPrices> allPrices = new ArrayList<InflatedMarketPrices>();
		for (Integer thisMarketId : lstMatchIds) {
			allPrices.add(service.getMarketPrices(thisMarketId));
		}
		//link these to bet_event object
		
		//get bet events for given round
		List<BetEvent> lstRoundEvents = userBettingDAO.getBetEventsByRoundId(1293L); //TODO: get round smartly
		
		for (BetEvent thisBetEvent : lstRoundEvents) {
			InflatedMarketPrices foundMarket = findMarketPricesForBetEvent(thisBetEvent, allPrices);
			if (foundMarket != null) {
				logger.info("setting market id:" + foundMarket.getMarketId());
				thisBetEvent.setExternalMarketId(foundMarket.getMarketId());
				userBettingDAO.updateBetEvent(thisBetEvent);
				
				//now generate betting prices
				for (BetParticipant thisBetParticipant : thisBetEvent.getLstBetParticipant()) {
					BetEventParticipantPrice betEventParticipantPrice = new BetEventParticipantPrice();
					InflatedRunner runner = getInflatedRunnerById(thisBetParticipant.getBetExternalId(), foundMarket.getRunners());
					if (runner != null) {
						betEventParticipantPrice.setBetEventId(thisBetEvent.getId());
						betEventParticipantPrice.setBetParticipant(thisBetParticipant);
						betEventParticipantPrice.setIsCurrent(true);
						betEventParticipantPrice.setOdds(runner.getLastPriceMatched());
						betEventParticipantPrice.setBetParticipantId(thisBetParticipant.getId());
						betEventParticipantPrice.setDateUpdated(new Date());
						userBettingDAO.createBetEventParticipantPrice(betEventParticipantPrice);
					}
				}
			}
		}
		
		service.logout();
	}
	
	private InflatedRunner getInflatedRunnerById(int id, List<InflatedRunner> lstRunners) {
		for (InflatedRunner thisRunner : lstRunners) {
			if (thisRunner.getSelectionId() == id) {
				return thisRunner;
			}
		}
		return null;
	}
	
	private InflatedMarketPrices findMarketPricesForBetEvent(BetEvent betEvent, List<InflatedMarketPrices> allPrices) {
		List<Integer> idsToFind = getLstBetParticipantsIds(betEvent);
		for (InflatedMarketPrices thisMarketPrice : allPrices) {
			if (getLstRunnerIds(thisMarketPrice).containsAll(idsToFind)) {
				return thisMarketPrice;
			}
		}
		return null;
	}
	
	private List<Integer> getLstRunnerIds(InflatedMarketPrices thisMarket) {//TODO move to concrete classes
		List<Integer> lstRunnerIds = new ArrayList<Integer>();
		for (InflatedRunner thisRunner : thisMarket.getRunners()) {
			lstRunnerIds.add(thisRunner.getSelectionId());
		}
		Collections.sort(lstRunnerIds);
		return lstRunnerIds;
	}
	
	private List<Integer> getLstBetParticipantsIds(BetEvent betEvent) {
		List<Integer> lstParticipantIds = new ArrayList<Integer>();
		for (BetParticipant thisParticipant : betEvent.getLstBetParticipant()) {
			lstParticipantIds.add(thisParticipant.getBetExternalId());
		}
		Collections.sort(lstParticipantIds);
		return lstParticipantIds;
	}

}
