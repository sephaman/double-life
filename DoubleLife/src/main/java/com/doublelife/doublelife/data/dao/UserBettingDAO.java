/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetEvent;
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
	
}
