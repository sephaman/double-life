/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;

/**
 * Interface for accessing the UserStock table.
 * @author Joseph McAleer
 *
 */
public interface UserStockDAO {
	
	/**
	 * Saves a stockorder to the database.
	 * @param stockOrder
	 */
	public void buyUserStock(StockOrder stockOrder);
	
	/**
	 * Updates a stock entry to reflect a sell.
	 * @param stockOrder
	 */
	public void sellUserStock(StockOrder stockOrder);
	
	/**
	 * Gets all current stock holdings for a user.
	 * @param userId
	 * @return
	 */
	public List<UserStockHolding> getUserStockHolding(long userId);
	
	/**
	 * get all stock ever held by the given user.
	 * @param userId
	 * @return
	 */
	public List<UserStockHolding> getAllHistoricalUserStockHolding(long userId);
   
   /**
	 * get a particular stock held by a user.
	 * @param userId
	 * @return
	 */
	public UserStockHolding getUserStockByStockCode(long userId, String stockCode);
}
