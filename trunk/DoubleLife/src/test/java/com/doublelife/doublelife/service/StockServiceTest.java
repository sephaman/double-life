package com.doublelife.doublelife.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.StockPortfolio;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;
import com.doublelife.doublelife.data.dao.StockOrderDAO;
import com.doublelife.doublelife.data.dao.UserDAO;
import com.doublelife.doublelife.services.StockProcessingService;
import com.doublelife.doublelife.services.StockService;
import com.doublelife.doublelife.services.UserStockService;
import com.doublelife.doublelife.services.impl.YahooStockServiceImpl;

/**
 * Integration tests for stock functionality.
 * @author Joseph McAleer
 *
 */
@ContextConfiguration(locations = { "/servlet-context-TEST.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StockServiceTest {

	@Autowired
	private StockService stockService;
	
	@Autowired
	private UserStockService userStockService;
	
	@Autowired
	private StockProcessingService stockProcessingService;
	
	@Autowired
	private StockOrderDAO stockOrderDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void testBuyStock() {
		//create a user
		User user = createUser();
		
		//create the stockOrder
		StockOrder stockOrder = generateBuyStockOrder(user.getId());
		
		//process the stock order
		Assert.assertEquals(stockProcessingService.checkAndProcessPendingStocksLivePrices(), 1);
		
		//check user has the stock
		List<UserStockHolding> lstUserStocks = userStockService.getUserStockHolding(user.getId());
		Assert.assertEquals(lstUserStocks.size(), 1);
		
		Assert.assertEquals(lstUserStocks.get(0).getStockCode(), "WBC.AX");
	}
	
	private User createUser() {
		User user = new User();
		user.setFirstName("Joe");
		user.setLastName("Mc");
		user.setPassword("pw");
		user.setUserName("joeMc");
		
		Assert.assertTrue(userDAO.createUser(user));
		return user;
	}
	
	private StockOrder generateBuyStockOrder(long userId) {
		StockOrder stockOrder = new StockOrder();
		stockOrder.setStockCode("WBC.AX");
		stockOrder.setIsBuyOrder(StockOrder.BUY_ORDER);
		stockOrder.setUserId(userId);
		stockOrder.setCompleted(0);
		stockOrder.setOrderDateTime(new Date());
		List<String> lstStockCode = new ArrayList<String>();
		lstStockCode.add("WBC.AX");
		stockOrder.setOrderPrice(stockService.retrieveStocks(lstStockCode).get(0).getCurrentPrice());
		
		Assert.assertTrue(stockOrderDAO.saveStockOrder(stockOrder));
		return stockOrder;
	}
	
	@Test
	public void testRetrieveStocks() {
		YahooStockServiceImpl yahoo = new YahooStockServiceImpl();
		List<String> lstStocks = new ArrayList<String>();
		lstStocks.add("WBC.AX");
		yahoo.retrieveStocks(lstStocks);
	}
	
	@Test
	public void testStockMapping() {
		StockPortfolio portFolio = getStockPortfolio();
		YahooStockServiceImpl yahoo = new YahooStockServiceImpl();
		Map<UserStockHolding, RetrievedStock> map = yahoo.getStockMappings(portFolio);
		Assert.assertTrue(map.size() == 1);
		for (UserStockHolding thisUserStock : map.keySet()) {
			Assert.assertFalse(map.get(thisUserStock) == null);
		}
	}
	
	private StockPortfolio getStockPortfolio() {
		List<UserStockHolding> holdings = new ArrayList<UserStockHolding>();
		UserStockHolding stockHolding = new UserStockHolding();
		stockHolding.setStockCode("WBC.AX");
		holdings.add(stockHolding);
		StockPortfolio portFolio = new StockPortfolio(holdings);
		
		return portFolio;
	}

	/**
	 * @return the stockService
	 */
	public StockService getStockService() {
		return stockService;
	}

	/**
	 * @param stockService the stockService to set
	 */
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	/**
	 * @return the userStockService
	 */
	public UserStockService getUserStockService() {
		return userStockService;
	}

	/**
	 * @param userStockService the userStockService to set
	 */
	public void setUserStockService(UserStockService userStockService) {
		this.userStockService = userStockService;
	}

	/**
	 * @return the stockProcessingService
	 */
	public StockProcessingService getStockProcessingService() {
		return stockProcessingService;
	}

	/**
	 * @param stockProcessingService the stockProcessingService to set
	 */
	public void setStockProcessingService(
			StockProcessingService stockProcessingService) {
		this.stockProcessingService = stockProcessingService;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @return the stockOrderDAO
	 */
	public StockOrderDAO getStockOrderDAO() {
		return stockOrderDAO;
	}

	/**
	 * @param stockOrderDAO the stockOrderDAO to set
	 */
	public void setStockOrderDAO(StockOrderDAO stockOrderDAO) {
		this.stockOrderDAO = stockOrderDAO;
	}
}
