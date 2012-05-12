/**
 * 
 */
package com.doublelife.doublelife.service;

import org.junit.Test;

import com.doublelife.doublelife.data.BetComp.retrievedBetData.InflatedMarketPrices;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.ArrayOfInt;
import com.doublelife.doublelife.services.impl.BFBetDataRetrieverServiceImpl;

/**
 * @author Joseph McAleer
 *
 */
public class BFDataRetrieverTest {

	private BFBetDataRetrieverServiceImpl service = new BFBetDataRetrieverServiceImpl();
	
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
		service.getAllMarketsData(arrInt);
		service.logout();
		
	}

}
