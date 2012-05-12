/**
 * 
 */
package com.doublelife.doublelife.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doublelife.doublelife.data.BetComp.retrievedBetData.InflatedMarketPrices;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.ArrayOfInt;
import com.doublelife.doublelife.services.impl.BFBetDataRetrieverServiceImpl;

/**
 * @author Joseph McAleer
 *
 */
public class BFDataRetrieverTest {

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

}
