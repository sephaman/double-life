/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.Bet;

/**
 * Provides useful services for betting.
 * @author Joseph McAleer
 */
public interface UserBettingService {

	/**
	 * Get the pending user bets.
	 * @return
	 */
	public List<Bet> getUserPendingBets(long userId);
	
}
