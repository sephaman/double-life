package com.doublelife.doublelife.services;

import java.util.List;
import java.util.Map;

import com.doublelife.doublelife.UserStockHolding;
import com.doublelife.doublelife.data.RetrievedStock;
import com.doublelife.doublelife.data.StockPortfolio;

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
	public List<RetrievedStock> retrieveStocks(List<String> lstStockCodes);
	
	/**
	 * Returns mapped user stock holdings. This allows for stock holdings
	 * to be compared to current prices.
	 * 
	 * Consider getting data from database instead (??)
	 * 
	 * @param userStockHolding
	 * @return
	 */
	public Map<UserStockHolding, RetrievedStock> getStockMappings(StockPortfolio stockPortFolio);
	
}

