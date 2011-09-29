package com.doublelife.doublelife.services;

/**
 * StockService interface that defines functionality for retrieving stock prices.
 * @author Joseph McAleer
 *
 */
public interface StockService {

	/**
	 * Returns the current price for the given stock code.
	 * @param stockCode 
	 * @return current price of stock code.
	 */
	public double getPrice(String stockCode);
	
}
