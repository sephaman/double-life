/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.dao.StockOrderDAO;

/**
 * Hibernate implementation of the StockDAO interface.
 * @author Joseph McAleer
 *
 */
public class HibernateStockOrderDAO implements StockOrderDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateStockOrderDAO.class);

	private final HibernateTemplate hibernate;
	
	public HibernateStockOrderDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.StockDAO#saveStockOrder(com.doublelife.doublelife.data.asset.stocks.StockOrder)
	 */
	public boolean saveStockOrder(StockOrder stockOrder) {
		boolean retval = false;
		logger.debug("Saving stock order.");
		try {
			stockOrder.setUpdateDateTime(new Date());
			hibernate.saveOrUpdate(stockOrder);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving stock order.", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.StockDAO#getStockOrder(long)
	 */
	public StockOrder getStockOrder(long stockOrderId) {
		List<StockOrder> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(StockOrder.class);
		detachedCriteria.add(Property.forName("id").eq(stockOrderId));
		
		try {
			retVal = (List<StockOrder>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving stock orders with stockOrderId", e);
		}
		if (!retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.StockDAO#getAllPendingStockOrders()
	 */
	public List<StockOrder> getAllPendingStockOrders() {
		List<StockOrder> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(StockOrder.class);
		detachedCriteria.add(Property.forName("completed").eq(StockOrder.PENDING_ORDER));
		
		try {
			retVal = (List<StockOrder>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets with stockOrderId", e);
		}
		return retVal;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.StockDAO#getAllPendingUserStockOrders(long)
	 */
	public List<StockOrder> getAllPendingUserStockOrders(long userId) {
		List<StockOrder> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(StockOrder.class);
		detachedCriteria.add(Property.forName("completed").eq(StockOrder.PENDING_ORDER));
		detachedCriteria.add(Property.forName("userId").eq(userId));
		
		try {
			retVal = (List<StockOrder>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets with stockOrderId", e);
		}
		return retVal;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.StockDAO#getAllUserStockOrders(long)
	 */
	public List<StockOrder> getAllUserStockOrders(long userId) {
		List<StockOrder> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(StockOrder.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		
		try {
			retVal = (List<StockOrder>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets with stockOrderId", e);
		}
		return retVal;
	}

}
