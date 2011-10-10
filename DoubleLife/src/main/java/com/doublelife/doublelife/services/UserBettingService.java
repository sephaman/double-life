/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventType;
import com.doublelife.doublelife.data.BetComp.BetParticipant;

/**
 * Provides useful services for betting.
 * @author Joseph McAleer
 */
public interface UserBettingService {

	/**
	 * Get the pending user bets.
	 * @param userId
	 * @return
	 */
	public List<Bet> getUserPendingBets(long userId);
	
	/**
	 * Saves a bet.
	 * @param bet
	 * @return
	 */
	public boolean createBet(Bet bet);
	
	/**
	 * Process bets by updating them with the result of the given bet event.
	 * @param betEvent 
	 */
	public void processBetResults(BetEvent betEvent);
	
	/**
	 * Add a betting participant to the system.
	 * @param betParticipant
	 */
	public void addBettingParticipant(BetParticipant betParticipant);
	
	/**
	 * Adds a registered participant to a bet event.
	 * @param betParticipant
	 * @param betEvent
	 */
	public void addParticipantToBettingEvent(BetParticipant betParticipant, BetEvent betEvent);
	
	/**
	 * Adds a new betEvent.
	 * @param betEvent
	 */
	public void addBetEvent(BetEvent betEvent);
	
	/**
	 * Adds a user betting account for the given user.
	 * @param user
	 */
	public void addUserBettingAccount(User user);
	
	/**
	 * Adds a new bet event type;
	 * @param betEventType
	 */
	public void addBetEventType(BetEventType betEventType);
	
	/**
	 * Updates the user betting account with the given amount.
	 * @param userId
	 * @param amount 
	 */
	public void updateUserBettingAccount(long userId, double amount);
}
