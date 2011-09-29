package com.doublelife.doublelife;

import org.junit.Test;

import com.doublelife.doublelife.services.impl.YahooStockServiceImpl;


public class StockServiceTest {

	@Test
	public void testGetPrice() {
		YahooStockServiceImpl yahoo = new YahooStockServiceImpl();
		double result = yahoo.getPrice("");
	}
}
