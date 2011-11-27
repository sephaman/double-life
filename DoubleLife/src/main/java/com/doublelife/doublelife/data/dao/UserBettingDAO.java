/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;
import java.util.Set;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice;
import com.doublelife.doublelife.data.BetComp.BetEventType;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.UserBettingAccount;

/**
 * Provides data access methods for betting related information.
 * @author Joseph McAleer
 *
 */
public interface UserBettingDAO {
	
	/**
	 * Gets all pending bets for the given user.
	 * @param userId 
	 * @return
	 */
	public List<Bet> getUserPendingBets(long userId);
	
	/**
	 * Get the count of pending bets.
	 * @param userId 
	 * @return
	 */
	public int getUserPendingBetCount(long userId);
	
	/**
	 * Get all bets made by the given user.
	 * @param userId 
	 * @return
	 */
	public List<Bet> getAllUserBets(long userId);
	
	/**
	 * Persists the given bet.
	 * @param bet 
	 * @return true if successful
	 */
	public boolean saveBet(Bet bet);
	
	
	/**
	 * Returns all bets for the given bet event.
	 * @param betEventId
	 * @return 
	 */
	public List<Bet> getBetsByBetEvent(long betEventId);
	
	/**
	 * Updates all given bets.
	 * @param lstBets
	 * @return
	 */
	public boolean updateAllBets(List<Bet> lstBets);
	
	/**
	 * Persists the bet event.
	 * @param betEvent
	 * @return
	 */
	public boolean createBetEvent(BetEvent betEvent);
	
	/**
	 * Creates a user betting account.
	 * @param userBettingAccount
	 * @return
	 */
	public boolean createUserBettingAccount(UserBettingAccount userBettingAccount);
	
	/**
	 * Returns the UserBettingAccount for the given userId.
	 * @param userId
	 * @return
	 */
	public UserBettingAccount getUserBettingAccountByUserId(long userId);
	
	/**
	 * Creates a bet participant.
	 * @param betParticipant
	 * @return
	 */
	public boolean createBetParticipant(BetParticipant betParticipant);

	/**
	 * @param betEventType
	 */
	public boolean createBetEventType(BetEventType betEventType);
	
	/**
	 * Gets all betting competitions.
	 * @return
	 */
	public List<BetCompetition> getAllCurrentCompetitions();
	
	/**
	 * Gets the BetCompetition by the id.
	 * @param id
	 * @return
	 */
	public BetCompetition getCompetitionById(long id);
	
	/**
	 * Create new betCompetition.
	 * @param betCompetition
	 * @return
	 */
	public boolean createBetCompetition(BetCompetition betCompetition);
	
	
	/**
	 * Returns all bet events available to bet on.
	 * @return
	 */
	public Set<BetEvent> getAllCurrentBetEvents();

	/**
	 * Returns the bet event for the given id.
	 * @param betEventId
	 * @return
	 */
	public BetEvent getBetEventById(long betEventId);
	
	/**
	 * Returns the Bet event participants prices.
	 * @param betEventId 
	 * @return
	 */
	public List<BetEventParticipantPrice> getBetEventParticipantPricesByEvent(long betEventId);
	
	/**
	 * Returns the list of bet participants for the given selection ids.
	 * @param selectionIds
	 * @return
	 */
	public Set<BetParticipant> getParticipantsBySelectionList(List<Long> selectionIds);

}
