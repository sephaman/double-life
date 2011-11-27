/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice;
import com.doublelife.doublelife.data.BetComp.BetEventType;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.UserBettingAccount;

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
	 * @return 
	 */
	public UserBettingAccount addUserBettingAccount(User user);
	
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
	
	/**
	 * Returns all bets for the given user.
	 * @param userId
	 * @return
	 */
	public List<Bet> getAllUserBets(long userId);
	
	/**
	 * Gets the user betting account with the provided user id.
	 * @param userId
	 * @return
	 */
	public UserBettingAccount getUserBettingAccount(long userId);
	
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
	 * Returns all current bet events.
	 * @return
	 */
	public Set<BetEvent> getAllCurrentBetEvents();

	/**
	 * Gets a bet event by id.
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
	 * Returns a map of participants and their prices.
	 * @param betEvent
	 * @return
	 */
	public Map<BetParticipant, Double> getMappedParticipantAndPrice(BetEvent betEvent);
	
	
	/**
	 * Creates and saves the bet.
	 * @param betEventId
	 * @param selectionId
	 * @param stake 
	 * @param odds 
	 * @return
	 */
	public boolean createAndSaveBet(long betEventId, long selectionId, double stake, double odds);
	
	/**
	 * Returns a map of bets and the selection made.
	 * @return
	 */
	public Map<Bet, String> getMappedBetAndSelection();
}
