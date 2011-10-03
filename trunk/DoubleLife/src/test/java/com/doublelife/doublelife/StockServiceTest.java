package com.doublelife.doublelife;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.doublelife.doublelife.data.RetrievedStock;
import com.doublelife.doublelife.data.StockPortfolio;
import com.doublelife.doublelife.services.impl.YahooStockServiceImpl;


public class StockServiceTest {

	@Test
	public void testRetrieveStocks() {
		YahooStockServiceImpl yahoo = new YahooStockServiceImpl();
		List<String> lstStocks = new ArrayList<String>();
		lstStocks.add("WBC.AX");
		yahoo.retrieveStocks(lstStocks);
	}
	
	@Test
	public void testStockMapping() {
		StockPortfolio portFolio = getStockPortfolio();
		YahooStockServiceImpl yahoo = new YahooStockServiceImpl();
		Map<UserStockHolding, RetrievedStock> map = yahoo.getStockMappings(portFolio);
		Assert.assertTrue(map.size() == 1);
		for (UserStockHolding thisUserStock : map.keySet()) {
			Assert.assertFalse(map.get(thisUserStock) == null);
		}
	}
	
	private StockPortfolio getStockPortfolio() {
		StockPortfolio portFolio = new StockPortfolio();
		UserStockHolding stockHolding = new UserStockHolding();
		stockHolding.setStockCode("WBC.AX");
		portFolio.getLstStocks().add(stockHolding);
		
		return portFolio;
	}
}
