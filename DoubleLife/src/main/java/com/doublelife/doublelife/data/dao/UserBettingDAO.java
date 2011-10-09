/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.Bet;

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
}
