package com.doublelife.doublelife;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.doublelife.doublelife.services.impl.YahooStockServiceImpl;


public class StockServiceTest {

	@Test
	public void testGetPrice() {
		YahooStockServiceImpl yahoo = new YahooStockServiceImpl();
		List<String> lstStocks = new ArrayList<String>();
		lstStocks.add("WBC.AX");
		yahoo.retrieveStocks(lstStocks);
	}
}
