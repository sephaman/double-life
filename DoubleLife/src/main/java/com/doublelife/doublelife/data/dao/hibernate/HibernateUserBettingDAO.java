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
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetResult;
import com.doublelife.doublelife.data.BetComp.UserBettingAccount;
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
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getBetsByBetEvent(long)
	 */
	public List<Bet> getBetsByBetEvent(long betEventId) {
		List<Bet> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bet.class);
		detachedCriteria.add(Property.forName("betEventId").eq(betEventId));
		detachedCriteria.add(Property.forName("betResult").eq(BetResult.PENDING));
		
		try {
			retVal = (List<Bet>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets with betEventId", e);
		}
		return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#updateAllBets(java.util.List)
	 */
	public boolean updateAllBets(final List<Bet> lstBets) {
		boolean retval = false;
		logger.debug("Saving bets collection.");
		try {
			hibernate.saveOrUpdateAll(lstBets);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving bets collection.", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createBetEvent(com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public boolean createBetEvent(BetEvent betEvent) {
		boolean retval = false;
		logger.debug("Saving bets collection.");
		try {
			hibernate.saveOrUpdate(betEvent);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving bet event.", e);
			throw e;
		}
		return retval;
	}
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createUserBettingAccount(com.doublelife.doublelife.data.BetComp.UserBettingAccount)
	 */
	public boolean createUserBettingAccount(
			UserBettingAccount userBettingAccount) {
		boolean retval = false;
		logger.debug("Saving bets collection.");
		try {
			hibernate.saveOrUpdate(userBettingAccount);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving user betting account.", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getUserBettingAccountByUserId(long)
	 */
	public UserBettingAccount getUserBettingAccountByUserId(long userId) {
		List<UserBettingAccount> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bet.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		
		try {
			retVal = (List<UserBettingAccount>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets with betEventId", e);
		}
		if (!retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}

}
