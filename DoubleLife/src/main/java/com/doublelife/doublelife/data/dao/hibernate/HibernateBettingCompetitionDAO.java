/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.data.dao.BettingCompetitionDAO;

/**
 * Hibernate implementation of Betting competion DAO.
 * @author Joseph McAleer
 *
 */
public class HibernateBettingCompetitionDAO implements BettingCompetitionDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateBettingCompetitionDAO.class);

	private final HibernateTemplate hibernate;
	
	/**
	 * @param sessionFactory
	 */
	public HibernateBettingCompetitionDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.BettingCompetitionDAO#createCompetition(com.doublelife.doublelife.data.BetComp.BetCompetition)
	 */
	public boolean createCompetition(BetCompetition betCompetition) {
		boolean retval = false;
		logger.debug("Saving betCompetition.");
		try {
			hibernate.saveOrUpdate(betCompetition);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving betCompetition.", e);
			throw e;
		}
		return retval;
	}

}
