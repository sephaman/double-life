/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;

/**
 * Interface describing functionality for managing stock.
 * @author Joseph McAleer
 *
 */
public interface StockDAO {

	/**
	 * Saves the given stockOrder.
	 * @param stockOrder
	 * @return
	 */
	public boolean saveStockOrder(StockOrder stockOrder);
	
	/**
	 * Gets the stockOrder for the given id.
	 * @param stockOrderId
	 * @return
	 */
	public StockOrder getStockOrder(long stockOrderId);
	
	/**
	 * Retrieves all pending stock orders.
	 * @return
	 */
	public List<StockOrder> getAllPendingStockOrders();
	
	
	/**
	 * Retrieves all pending stock orders for the given user.
	 * @param userId
	 * @return
	 */
	public List<StockOrder> getAllPendingUserStockOrders(long userId);
	
	/**
	 * Retrieves all stock orders for the given user.
	 * @param userId
	 * @return
	 */
	public List<StockOrder> getAllUserStockOrders(long userId);
	
	
	/**
	 * Processes any pending stock orders.
	 * @return
	 */
	public int processPendingStockOrders();
}
