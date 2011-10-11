/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.User;
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

}
