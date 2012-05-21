/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.retrievedBetData.InflatedMarketPrices;
import com.doublelife.doublelife.data.BetComp.retrievedBetData.InflatedMarketPrices.InflatedRunner;
import com.doublelife.doublelife.data.dao.UserBettingDAO;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.ArrayOfInt;
import com.doublelife.doublelife.services.BetDataRetrieverService;

/**
 * Service implementation of BetDataRetrieverService for retrieving AFL data.
 * @author Joseph McAleer
 *
 */
public class BFAflBetDataRetrieverServiceImpl extends BFBetDataRetrieverServiceImpl implements BetDataRetrieverService {

	@Autowired
	private UserBettingDAO userBettingDAO;	
	
	private final static int BETFAIR_AFL_ID = 61420;
	
	private final Logger logger = LoggerFactory.getLogger(BFAflBetDataRetrieverServiceImpl.class);
	
	
	/**
	 * Gets all active AFL markets.
	 * @throws Exception
	 */
	public void getAllAFLMarketsData() throws Exception {
		login();
		ArrayOfInt arrInt = new ArrayOfInt();
		int[] nums = new int[1];
		nums[0] = BETFAIR_AFL_ID;
		arrInt.set_int(nums);
		String resp = getAllMarketsData(arrInt);
		List<Integer> lstMatchIds = getAllMatchIdsForMatchOdds(resp);
		
		List<InflatedMarketPrices> allPrices = new ArrayList<InflatedMarketPrices>();
		for (Integer thisMarketId : lstMatchIds) {
			allPrices.add(getMarketPrices(thisMarketId));
		}
		
		for (InflatedMarketPrices thisMarketPrice : allPrices) {
			logger.info("Market Prices: " + thisMarketPrice.getMarketId() + " Runner 1:" 
		+ thisMarketPrice.getRunners().get(0).getSelectionId() + " - " + thisMarketPrice.getRunners().get(0).getLastPriceMatched() + " Runner 2:" 
				+ thisMarketPrice.getRunners().get(1).getSelectionId() + " - " + thisMarketPrice.getRunners().get(1).getLastPriceMatched());
		}
		
		logout();
	}
	
	/**
	 * Get all prices for a round.
	 * @param roundId
	 * @throws Exception
	 */
	public void getPricesForRound(long roundId) throws Exception {
		login();
		ArrayOfInt arrInt = new ArrayOfInt();
		int[] nums = new int[1];
		nums[0] = 61420;
		arrInt.set_int(nums);
		String resp = getAllMarketsData(arrInt);
		List<Integer> lstMatchIds = getAllMatchIdsForMatchOdds(resp);
		
		List<InflatedMarketPrices> allPrices = new ArrayList<InflatedMarketPrices>();
		for (Integer thisMarketId : lstMatchIds) {
			allPrices.add(getMarketPrices(thisMarketId));
		}
		//link these to bet_event object
		
		//get bet events for given round
		List<BetEvent> lstRoundEvents = userBettingDAO.getBetEventsByRoundId(roundId);
		
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
		
		logout();
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
	
	private List<Integer> getLstRunnerIds(InflatedMarketPrices thisMarket) {
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
