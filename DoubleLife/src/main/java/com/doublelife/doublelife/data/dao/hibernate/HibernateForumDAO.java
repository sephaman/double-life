/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.BetComp.ForumTopic;
import com.doublelife.doublelife.data.dao.ForumDAO;

/**
 * Hibernate implementation of the BankingDAO interface.
 * @author Joseph McAleer
 *
 */
public class HibernateForumDAO implements ForumDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateForumDAO.class);

	private final HibernateTemplate hibernate;
	
	public HibernateForumDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.ForumDAO#getAllForumTopics()
	 */
	public List<ForumTopic> getAllForumTopics() {
		List<ForumTopic> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ForumTopic.class);
		detachedCriteria.addOrder(Order.asc("createDateTime"));
		try {
			retVal = (List<ForumTopic>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving forum topics", e);
		}
			return retVal;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.ForumDAO#addForumTopic(com.doublelife.doublelife.data.BetComp.ForumTopic)
	 */
	public boolean addForumTopic(ForumTopic forumTopic) {
		boolean retval = false;
		logger.debug("Saving Forum Topic");
		try {
			forumTopic.setCreateDateTime(new Date());
			hibernate.save(forumTopic);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving forum topic", e);
			throw e;
		}
		return retval;
	}
	
}
