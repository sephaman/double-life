/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetResult;
import com.doublelife.doublelife.data.dao.UserBettingDAO;

/**
 * Hibernate implementation of User Betting DAO.
 * @author Joseph McAleer
 *
 */
public class HibernateUserBettingDAO implements UserBettingDAO {

	private final Logger logger = LoggerFactory.getLogger(HibernateUserBettingDAO.class);

	private final HibernateTemplate hibernate;
	
	/**
	 * @param sessionFactory
	 */
	public HibernateUserBettingDAO(final SessionFactory sessionFactory) {
		this.hibernate = new HibernateTemplate(sessionFactory);
	}
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getUserPendingBets(long)
	 */
	public List<Bet> getUserPendingBets(long userId) {
		List<Bet> retVal = new ArrayList<Bet>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bet.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		detachedCriteria.add(Property.forName("betResult").eq(BetResult.PENDING));
		
		try {
			retVal = (List<Bet>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets", e);
		}
		return retVal;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getUserPendingBetCount(long)
	 */
	public int getUserPendingBetCount(long userId) {
		List<Bet> retVal = new ArrayList<Bet>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bet.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		detachedCriteria.add(Property.forName("betResult").eq(BetResult.PENDING));
		
		try {
			retVal = (List<Bet>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets", e);
		}
		return retVal.size();
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getAllUserBets(long)
	 */
	@SuppressWarnings("unchecked")
	public List<Bet> getAllUserBets(long userId) {
		List<Bet> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bet.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		
		try {
			retVal = (List<Bet>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets", e);
		}
		return retVal;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#saveBet(com.doublelife.doublelife.data.BetComp.Bet)
	 */
	public boolean saveBet(Bet bet) {
		try {
			hibernate.saveOrUpdate(bet);
			return true;
		} catch (DataAccessException e) {
			logger.error("Error saving bet.", e);
			return false;
		}
	}

}
