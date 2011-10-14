/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;

/**
 * Represents the service functionality for user stocks.
 * @author Joseph McAleer
 *
 */
public interface UserStockService {

	/**
	 * Processes a buy order of stock.
	 * @param stockOrder
	 * @return
	 */
	public boolean buyUserStock(StockOrder stockOrder);
	
	/**
	 * Processes a sell order of stock.
	 * @param stockOrder
	 * @return
	 */
	public boolean sellUserStock(StockOrder stockOrder);
	
	/**
	 * Returns the list of user stock holdings.
	 * @param userId
	 * @return
	 */
	public List<UserStockHolding> getUserStockHolding(long userId);
	
	/**
	 * Returns a particular stock-holding for the user with the given stock code.
	 * @param userId
	 * @param stockCode
	 * @return
	 */
	public UserStockHolding getUserStockHoldingByStockCode(long userId, String stockCode);
}
