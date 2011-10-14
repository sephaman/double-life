/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

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
	
	/**
	 * @param sessionFactory
	 */
	public HibernateUserStockDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#getUserStockHolding(long)
	 */
	@SuppressWarnings("unchecked")
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
     @SuppressWarnings("unchecked")
	public UserStockHolding getUserStockByStockCode(long userId, String stockCode) {
      List<UserStockHolding> retVal = null;
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserStockHolding.class);
        detachedCriteria.add(Property.forName("userId").eq(userId));
        detachedCriteria.add(Property.forName("stockCode").eq(stockCode));
        //TODO: must be active!

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

	/**
	 * @see com.doublelife.doublelife.data.dao.UserStockDAO#saveUserStockHolding(com.doublelife.doublelife.data.asset.stocks.UserStockHolding)
	 */
	public boolean saveUserStockHolding(UserStockHolding userStockHolding) {
		boolean retval = false;
		logger.debug("Saving userStockHolding.");
		try {
			hibernate.saveOrUpdate(userStockHolding);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving userStockHolding.", e);
			throw e;
		}
		return retval;
	}


}
