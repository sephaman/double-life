/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;
import com.doublelife.doublelife.data.dao.UserStockDAO;

/**
 * Hibernate implementation for the UserStockDAO.
 * @author Joseph McAleer
 *
 */
public class HibernateUserStockDAO implements UserStockDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateUserStockDAO.class);

	private final HibernateTemplate hibernate;
	
	public HibernateUserStockDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#buyUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)
	 */
	public void buyUserStock(StockOrder stockOrder) {
		UserStockHolding ush = (UserStockHolding) hibernate.get(UserStockHolding.class, 1L);
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
        List<UserStockHolding> retVal = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserStockHolding.class);
        detachedCriteria.add(Property.forName("userId").eq(userId));
  //TODO: where quantity is greater than 0!
        try {
                retVal = (List<UserStockHolding>) hibernate.findByCriteria(detachedCriteria);
        } catch (DataAccessException e) {
                logger.error("Error retrieving user stock holding", e);
        }
        if (!retVal.isEmpty()) {
                return retVal;
        }
        return null;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#getAllHistoricalUserStockHolding(long)
	 */
	public List<UserStockHolding> getAllHistoricalUserStockHolding(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

  /**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#getUserStockByStockCode(long, String)
	 */
     public UserStockHolding getUserStockByStockCode(long userId, String stockCode) {
      List<UserStockHolding> retVal = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserStockHolding.class);
        detachedCriteria.add(Property.forName("userId").eq(userId));
        detachedCriteria.add(Property.forName("stockCode").eq(stockCode));

        try {
                retVal = (List<UserStockHolding>) hibernate.findByCriteria(detachedCriteria);
        } catch (DataAccessException e) {
                logger.error("Error retrieving user stock holding by stockcode", e);
        }
        if (!retVal.isEmpty()) {
                return retVal.get(0);
        }
        return null;
     
     }


}
