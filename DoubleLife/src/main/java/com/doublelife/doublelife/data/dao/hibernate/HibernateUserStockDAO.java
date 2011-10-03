/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.List;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;
import com.doublelife.doublelife.data.dao.UserStockDAO;

/**
 * Hibernate implementation for the UserStockDAO.
 * @author Joseph McAleer
 *
 */
public class HibernateUserStockDAO implements UserStockDAO {

	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#buyUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)
	 */
	public void buyUserStock(StockOrder stockOrder) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#sellUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)
	 */
	public void sellUserStock(StockOrder stockOrder) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#getUserStockHolding(long)
	 */
	public List<UserStockHolding> getUserStockHolding(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#getAllHistoricalUserStockHolding(long)
	 */
	public List<UserStockHolding> getAllHistoricalUserStockHolding(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
