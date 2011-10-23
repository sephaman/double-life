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

import com.doublelife.doublelife.data.Competition;
import com.doublelife.doublelife.data.dao.CompetitionDAO;

/**
 * Hibernate implementation of Competition DAO.
 * @author Joseph McAleer
 *
 */
public class HibernateCompetitionDAO implements CompetitionDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateCompetitionDAO.class);

	private final HibernateTemplate hibernate;
	
	/**
	 * @param sessionFactory
	 */
	public HibernateCompetitionDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.CompetitionDAO#getAllCurrentCompetitions()
	 */
	public List<Competition> getAllCurrentCompetitions() {
		List<Competition> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Competition.class);
		detachedCriteria.add(Property.forName("isActive").eq(1));
		
		try {
			retVal = (List<Competition>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving competitions", e);
		}
			return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.CompetitionDAO#getCompetitionById(long)
	 */
	@SuppressWarnings("unchecked")
	public Competition getCompetitionById(long id) {
		List<Competition> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Competition.class);
		detachedCriteria.add(Property.forName("id").eq(id));
		
		try {
			retVal = (List<Competition>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving Competition with Id", e);
		}
		if (retVal != null && !retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.CompetitionDAO#createCompetition(com.doublelife.doublelife.data.Competition)
	 */
	public boolean createCompetition(Competition competition) {
		boolean retval = false;
		logger.debug("Saving competition");
		try {
			competition.setUpdateDateTime(new Date());
			hibernate.saveOrUpdate(competition);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving competition", e);
			throw e;
		}
		return retval;
	}

}
