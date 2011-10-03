package com.doublelife.doublelife.services;

import java.util.List;
import java.util.Map;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.StockPortfolio;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;

/**
 * StockService interface that defines functionality for retrieving stock prices.
 * @author Joseph McAleer
 *
 */
public interface StockService {

	/**
	 * Returns the current price for the given stock code.
	 * @param lstStockCodes 
	 * @param stockCode 
	 * @return current price of stock code.
	 */
	public List<RetrievedStock> retrieveStocks(List<String> lstStockCodes);
	
	/**
	 * Returns mapped user stock holdings. This allows for stock holdings
	 * to be compared to current prices.
	 * 
	 * Consider getting data from database instead (??)
	 * @param stockPortFolio 
	 * 
	 * @param userStockHolding
	 * @return
	 */
	public Map<UserStockHolding, RetrievedStock> getStockMappings(StockPortfolio stockPortFolio);
	
	/**
	 * Perform a buy of stock.
	 * @param stockOrder
	 */
	public void buyUserStock(StockOrder stockOrder);
	/**
	 * Perform a sell of stock.
	 * @param stockOrder
	 */
	public void sellUserStock(StockOrder stockOrder);
	
	/**
	 * Generates a buy stockorder with the given values.
	 * @param userId
	 * @param quantity
	 * @param price
	 * @param isBuy
	 * @return
	 */
	public StockOrder generateBuyStockOrder(long userId, int quantity, double price,
			 RetrievedStock retrievedStock);
	
	/**
	 * Generates a sell stock order with the given values.
	 * @param userId
	 * @param userStockHolding
	 * @return
	 */
	public StockOrder generateSellStockOrder(long userId, UserStockHolding userStockHolding);
}

