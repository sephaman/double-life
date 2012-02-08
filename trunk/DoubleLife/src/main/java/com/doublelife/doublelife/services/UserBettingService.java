/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetCompRules;
import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice;
import com.doublelife.doublelife.data.BetComp.BetEventType;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.BetTip;
import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
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
	 * Adds a new betEvent.
	 * @param betEvent
	 */
	public boolean createBetEvent(BetEvent betEvent);
	
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
	 * @param bet 
	 * @return 
	 */
	public boolean updateUserBettingAccount(Bet bet);
	
	/**
	 * Returns all bets for the given user.
	 * @param userId
	 * @return
	 */
	public List<Bet> getAllUserBets(long userId);
	
	/**
	 * Gets the user betting account with the provided user id.
	 * @param userId
	 * @param compId 
	 * @return
	 */
	public UserBettingAccount getUserBettingAccount(long userId, long compId);
	
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

	/**
	 * creates a a bet competition for the current user.
	 * @param betComp
	 * @param userId 
	 */
	public void createNewBettingAccount(BetCompetition betComp, long userId);
	
	/**
	 * Returns all Bet Participants.
	 * @return
	 */
	public List<BetParticipant> getAllBetParticipants();

	/**
	 * Returns all bet event types.
	 * @return
	 */
	public List<BetEventType> getAllBetEventTypes();
	
	/**
	 * Returns the Bet Participant by name.
	 * @param id
	 * @return
	 */
	public BetParticipant getParticipantById(long id);
	
	/**
	 * Saves a new BetEventParticipantPrice object.
	 * @param betEventParticipantPrice
	 * @return
	 */
	public boolean createBetEventParticipantPrice(BetEventParticipantPrice betEventParticipantPrice);

	/**
	 * Creates all bet event participant prices associated with the bet event.
	 * @param betEvent
	 */
	public void createAllBetEventParticipantPrices(BetEvent betEvent);
	
	/**
	 * Generates an ordered mapped leaderboard based on the users and their current money. 
	 * @param betttingCompetitionId
	 * @return
	 */
	public Map<User, Double> getLeaderBoardForCompetition(long betttingCompetitionId);
	
	/**
	 * Create a season.
	 * @param season
	 * @return
	 */
	public boolean createSeason(Season season);
	
	/**
	 * Creates a Round.
	 * @param round 
	 * @return
	 */
	public boolean createRound(Round round);
	
	/**
	 * Returns all seasons.
	 * @return
	 */
	public List<Season> getAllSeasons();
	
	/**
	 * Returns all Seasons for a given Bet Event Type.
	 * @param betEventType
	 * @return
	 */
	public List<Season> getAllSeasonsByBetEventType(long betEventType);

	/**
	 * Returns the season for the given id.
	 * @param seasonId
	 * @return
	 */
	public Season getSeasonById(long seasonId);
	
	/**
	 * Returns list of rounds for a given season.
	 * @param seasonId
	 * @return
	 */
	public List<Round> getRoundsBySeasonId(long seasonId);

	/**
	 * Returns the round for the given round Id.
	 * @param roundId
	 * @return
	 */
	public Round getRoundById(long roundId);

	/**
	 * Returns the list of bet events for a given round id.
	 * @param roundId
	 * @return
	 */
	public List<BetEvent> getBetEventsByRoundId(long roundId);

	/**
	 * Returns the bet event type by id.
	 * @param betEventTypeId
	 * @return
	 */
	public BetEventType getBetEventTypeById(long betEventTypeId);

	/**
	 * Updates the betting prices for the given bet event.
	 * @param idPrices
	 * @param betPrices
	 * @param betEvent
	 * @return
	 */
	public boolean updateSubmittedBetPrices(String idPrices, String betPrices,
			BetEvent betEvent);
	
	/**
	 * Updates a betEvent.
	 * @param betEvent
	 * @return
	 */
	public boolean updateBetEvent(BetEvent betEvent);
	
	/**
	 * Returns the active round for this season.
	 * @param seasonId
	 * @return
	 */
	public Round getActiveRoundForComp(long seasonId);
	
	/**
	 * Returns the BetCompRules for the given competition.
	 * @param compId
	 * @return
	 */
	public BetCompRules getBetCompRulesByCompId(long compId);

	/**
	 * Creates the betTip.
	 * @param betTip
	 * @return
	 */
	public boolean createBetTip(BetTip betTip);

	/**
	 * Returns users bets by round & comp.
	 * @param roundId
	 * @param compId
	 * @return
	 */
	public List<Bet> getUserBetsByRoundAndComp(long roundId, long compId, long userId);
}
