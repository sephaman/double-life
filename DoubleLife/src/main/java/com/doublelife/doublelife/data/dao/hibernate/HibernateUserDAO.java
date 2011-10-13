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

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.BetComp.UserBettingAccount;
import com.doublelife.doublelife.data.dao.UserDAO;

/**
 * @author Joseph McAleer
 *
 */
public class HibernateUserDAO implements UserDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateUserDAO.class);

	private final HibernateTemplate hibernate;
	
	public HibernateUserDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserDAO#getUserPassword(com.doublelife.doublelife.data.User)
	 */
	public String getUserPassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserDAO#getUserById(long)
	 */
	public User getUserById(long userId) {
		List<User> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserBettingAccount.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		
		try {
			retVal = (List<User>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets with betEventId", e);
		}
		if (!retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}

}
