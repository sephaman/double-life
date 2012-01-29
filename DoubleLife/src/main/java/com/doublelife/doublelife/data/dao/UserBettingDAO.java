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
import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
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
	 * @param userBettingAccount
	 * @return
	 */
	public boolean updateUserBettingAccount(UserBettingAccount userBettingAccount);
	
	/**
	 * Returns the UserBettingAccount for the given userId.
	 * @param userId
	 * @return
	 */
	public UserBettingAccount getUserBettingAccountByUserId(long userId, long compId);
	
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
	 * Saves a new BetEventParticipantPrice object.
	 * @param betEventParticipantPrice
	 * @return
	 */
	public boolean createBetEventParticipantPrice(BetEventParticipantPrice betEventParticipantPrice);
	
	/**
	 * Returns the list of bet participants for the given selection ids.
	 * @param selectionIds
	 * @return
	 */
	public Set<BetParticipant> getParticipantsBySelectionList(List<Long> selectionIds);

	/**
	 * Returns all bet participants.
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
	 * Returns list of user betting accounts for given comp id.
	 * @param compId
	 * @return
	 */
	public List<UserBettingAccount> getLstUserBettingAccountByCompId(long compId);

	/**
	 * Creates a Season.
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
	 * Returns all seasons by bet event type.
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
	 * Returns the list of rounds for an associated season.
	 * @param seasonId
	 * @return
	 */
	public List<Round> getRoundsBySeasonId(long seasonId);

	/**
	 * Returns a round by id.
	 * @param roundId
	 * @return
	 */
	public Round getRoundById(long roundId);

	/**
	 * Returns a list of bet events by round id.
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
	 * Gets the bet participant price based on event and participant ids.
	 * @param betEventParticipantPrice
	 * @return
	 */
	public BetEventParticipantPrice getBetParticipantPriceByEventAndPartipantId(BetEventParticipantPrice betEventParticipantPrice);

	/**
	 * Updates a betEvent.
	 * @param betEvent
	 * @return
	 */
	public boolean updateBetEvent(BetEvent betEvent);
	
}
