/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.Date;
import java.util.List;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;
import com.doublelife.doublelife.data.dao.UserStockDAO;
import com.doublelife.doublelife.services.UserStockService;

/**
 * Implementation of the UserStockService.
 * @author Joseph McAleer
 *
 */
public class UserStockServiceImpl implements UserStockService {

	private UserStockDAO userStockDAO;
	
	/**
	 * @see com.doublelife.doublelife.services.UserStockService#buyUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)
	 */
	public boolean buyUserStock(StockOrder stockOrder) {
		//check user has stock already
		boolean isNewStock = false;
		UserStockHolding userStockHolding = 
			getUserStockHoldingByStockCode(stockOrder.getUserId(), stockOrder.getStockCode());
		if (userStockHolding == null) {
			isNewStock = true;
			userStockHolding = createNewStockHolding(stockOrder);
		}
		
		userStockHolding.setQuantityHeld(userStockHolding.getQuantityHeld() + stockOrder.getQuantity());
		userStockHolding.setDateAcquired(new Date());
		userStockHolding.setCostBasis(stockOrder.getOrderPrice());
		//TODO: calculate cost basis properly!
		
		return userStockDAO.saveUserStockHolding(userStockHolding);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserStockService#sellUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)
	 */
	public boolean sellUserStock(StockOrder stockOrder) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserStockService#getUserStockHolding(long)
	 */
	public List<UserStockHolding> getUserStockHolding(long userId) {
		return userStockDAO.getUserStockHolding(userId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserStockService#getUserStockHoldingByStockCode(long, java.lang.String)
	 */
	public UserStockHolding getUserStockHoldingByStockCode(long userId,
			String stockCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private UserStockHolding createNewStockHolding(StockOrder stockOrder) {
		UserStockHolding userStockHolding = new UserStockHolding();
		userStockHolding.setStockCode(stockOrder.getStockCode());
		userStockHolding.setUserId(stockOrder.getUserId());
		userStockHolding.setCostBasis(0.00);
		userStockHolding.setQuantityHeld(0);
		
		return userStockHolding;
	}

	/**
	 * @param userStockDAO the userStockDAO to set
	 */
	public void setUserStockDAO(UserStockDAO userStockDAO) {
		this.userStockDAO = userStockDAO;
	}

	/**
	 * @return the userStockDAO
	 */
	public UserStockDAO getUserStockDAO() {
		return userStockDAO;
	}

}
