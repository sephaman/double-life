/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;

/**
 * @author Joseph McAleer
 *
 */
@ContextConfiguration(locations = { "/servlet-context-TEST.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserStockDAOTest {

	@Autowired
	private UserStockDAO userStockDAO;
	
	/**
	 * Test method for {@link com.doublelife.doublelife.data.dao.hibernate.HibernateUserStockDAO#buyUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)}.
	 */
	@Test
	public void testBuyUserStock() {
		StockOrder stockOrder = new StockOrder();
		userStockDAO.buyUserStock(stockOrder);
	}

	/**
	 * Test method for {@link com.doublelife.doublelife.data.dao.hibernate.HibernateUserStockDAO#sellUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)}.
	 */
	@Test
	public void testSellUserStock() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.doublelife.doublelife.data.dao.hibernate.HibernateUserStockDAO#getUserStockHolding(long)}.
	 */
	@Test
	public void testGetUserStockHolding() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.doublelife.doublelife.data.dao.hibernate.HibernateUserStockDAO#getAllHistoricalUserStockHolding(long)}.
	 */
	@Test
	public void testGetAllHistoricalUserStockHolding() {
		fail("Not yet implemented");
	}

	/**
	 * @return the userStockDAO
	 */
	public UserStockDAO getUserStockDAO() {
		return userStockDAO;
	}

	/**
	 * @param userStockDAO the userStockDAO to set
	 */
	public void setUserStockDAO(UserStockDAO userStockDAO) {
		this.userStockDAO = userStockDAO;
	}

}
