/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice;
import com.doublelife.doublelife.data.BetComp.BetEventType;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.BetResult;
import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
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
			hibernate.save(betEvent);
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
		logger.debug("Saving user betting account");
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
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#updateUserBettingAccount(com.doublelife.doublelife.data.BetComp.UserBettingAccount)
	 */
	public boolean updateUserBettingAccount(
			UserBettingAccount userBettingAccount) {
		boolean retval = false;
		logger.debug("Updating user betting account");
		try {
			hibernate.update(userBettingAccount);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error updating user betting account.", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getUserBettingAccountByUserId(long)
	 */
	public UserBettingAccount getUserBettingAccountByUserId(long userId, long compId) {
		List<UserBettingAccount> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserBettingAccount.class);
		detachedCriteria.add(Property.forName("userId").eq(userId));
		detachedCriteria.add(Property.forName("compId").eq(compId));
		
		try {
			retVal = (List<UserBettingAccount>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user bets with betEventId", e);
		}
		if (retVal != null && !retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createBetParticipant(com.doublelife.doublelife.data.BetComp.BetParticipant)
	 */
	public boolean createBetParticipant(BetParticipant betParticipant) {
		boolean retval = false;
		logger.debug("Saving bet participant");
		try {
			hibernate.saveOrUpdate(betParticipant);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving bet participant", e);
			throw e;
		}
		return retval;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createBetEventType(com.doublelife.doublelife.data.BetComp.BetEventType)
	 */
	public boolean createBetEventType(BetEventType betEventType) {
		boolean retval = false;
		logger.debug("Saving bet event type");
		try {
			hibernate.saveOrUpdate(betEventType);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving bet event type", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getAllCurrentCompetitions()
	 */
	public List<BetCompetition> getAllCurrentCompetitions() {
		List<BetCompetition> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetCompetition.class);
		detachedCriteria.add(Property.forName("isActive").eq(1));
		
		try {
			retVal = (List<BetCompetition>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving bet competitions", e);
		}
			return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getCompetitionById(long)
	 */
	@SuppressWarnings("unchecked")
	public BetCompetition getCompetitionById(long id) {
		List<BetCompetition> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetCompetition.class);
		detachedCriteria.add(Property.forName("id").eq(id));
		
		try {
			retVal = (List<BetCompetition>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving user BetCompetition with Id", e);
		}
		if (retVal != null && !retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createBetCompetition(com.doublelife.doublelife.data.BetComp.BetCompetition)
	 */
	public boolean createBetCompetition(BetCompetition betCompetition) {
		boolean retval = false;
		logger.debug("Saving bet competition");
		try {
			betCompetition.setUpdateDateTime(new Date());
			hibernate.saveOrUpdate(betCompetition);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving bet competition", e);
			throw e;
		}
		return retval;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getAllCurrentBetEvents()
	 */
	@SuppressWarnings("unchecked")
	public Set<BetEvent> getAllCurrentBetEvents() {
		List<BetEvent> retVal = new ArrayList<BetEvent>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetEvent.class);
		detachedCriteria.add(Property.forName("isOutcomePending").eq(Boolean.TRUE));
		
		try {
			retVal = (List<BetEvent>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving current bet events", e);
		}
		return new HashSet(retVal);
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getBetEventById(long)
	 */
	public BetEvent getBetEventById(long betEventId) {
		List<BetEvent> retVal = new ArrayList<BetEvent>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetEvent.class);
		detachedCriteria.add(Property.forName("id").eq(betEventId));
		
		try {
			retVal = (List<BetEvent>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving bet event", e);
		}
		if (retVal != null && !retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getBetEventParticipantPricesByEvent(long)
	 */
	public List<BetEventParticipantPrice> getBetEventParticipantPricesByEvent(
			long betEventId) {
		List<BetEventParticipantPrice> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetEventParticipantPrice.class);
		detachedCriteria.add(Property.forName("isCurrent").eq(Boolean.TRUE));
		detachedCriteria.add(Property.forName("betEventId").eq(betEventId));
		
		try {
			retVal = (List<BetEventParticipantPrice>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving betevent participant prices", e);
		}
			return retVal;
	}

	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getParticipantsBySelectionList(java.util.List)
	 */
	public Set<BetParticipant> getParticipantsBySelectionList(
			List<Long> selectionIds) {
		List<BetParticipant> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetParticipant.class);
		detachedCriteria.add(Property.forName("id").in(selectionIds));
		
		try {
			retVal = (List<BetParticipant>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving bet participants", e);
		}
			return new HashSet<BetParticipant>(retVal);

	}
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getAllBetParticipants()
	 */
	public List<BetParticipant> getAllBetParticipants() {
		List<BetParticipant> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetParticipant.class);
		
		try {
			retVal = (List<BetParticipant>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving bet participants", e);
		}
			return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getAllBetEventTypes()
	 */
	public List<BetEventType> getAllBetEventTypes() {
		List<BetEventType> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetEventType.class);
		
		try {
			retVal = (List<BetEventType>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving bet event types", e);
		}
			return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getParticipantById(long)
	 */
	public BetParticipant getParticipantById(long id) {
		List<BetParticipant> retVal = new ArrayList<BetParticipant>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BetParticipant.class);
		detachedCriteria.add(Property.forName("id").eq(id));
		
		try {
			retVal = (List<BetParticipant>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving BetParticipant", e);
		}
		if (retVal != null && !retVal.isEmpty()) {
			return retVal.get(0);
		}
		return null;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createBetEventParticipantPrice(com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice)
	 */
	public boolean createBetEventParticipantPrice(
			BetEventParticipantPrice betEventParticipantPrice) {
		boolean retval = false;
		logger.debug("Saving betEventParticipantPrice");
		try {
			betEventParticipantPrice.setDateUpdated(new Date());
			hibernate.save(betEventParticipantPrice);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving betEventParticipantPrice", e);
			throw e;
		}
		return retval;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getLstUserBettingAccountByCompId(long)
	 */
	public List<UserBettingAccount> getLstUserBettingAccountByCompId(long compId) {
		List<UserBettingAccount> retVal = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserBettingAccount.class);
		detachedCriteria.add(Property.forName("compId").eq(compId));
		
		try {
			retVal = (List<UserBettingAccount>) hibernate.findByCriteria(detachedCriteria);
		} catch (DataAccessException e) {
			logger.error("Error retrieving betevent participant prices", e);
		}
			return retVal;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createSeason(com.doublelife.doublelife.data.BetComp.Season)
	 */
	public boolean createSeason(Season season) {
		boolean retval = false;
		logger.debug("Saving Season");
		try {
			season.setUpdateDateTime(new Date());
			hibernate.save(season);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving season", e);
			throw e;
		}
		return retval;
	}
	
	/**
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#createRound(com.doublelife.doublelife.data.BetComp.Round)
	 */
	public boolean createRound(Round round) {
		boolean retval = false;
		logger.debug("Saving Round");
		try {
			hibernate.save(round);
			retval = true;
		} catch (DataAccessException e) {
			logger.error("Error saving round", e);
			throw e;
		}
		return retval;
	}

}
