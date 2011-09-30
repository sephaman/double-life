package com.doublelife.doublelife.services.impl;

import com.doublelife.doublelife.services.StockService;

/**
 * A mock service implementation for stock service.
 * @author Joseph McAleer
 *
 */
public class StockServiceTestImpl implements StockService {

	/**
	 * @see com.doublelife.doublelife.services.StockService#getPrice(java.lang.String)
	 */
	public double getPrice(String stockCode) {
		return Math.random() * 100;
	}

}
