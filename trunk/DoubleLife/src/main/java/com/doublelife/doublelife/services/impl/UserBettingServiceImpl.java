/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
import com.doublelife.doublelife.data.BetComp.BetResult;
import com.doublelife.doublelife.data.BetComp.BetTip;
import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
import com.doublelife.doublelife.data.BetComp.UserBettingAccount;
import com.doublelife.doublelife.data.dao.BettingCompetitionDAO;
import com.doublelife.doublelife.data.dao.UserBettingDAO;
import com.doublelife.doublelife.data.dao.UserDAO;
import com.doublelife.doublelife.services.UserBettingService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Implementation of the UserBetting Service.
 * @author Joseph McAleer
 *
 */
public class UserBettingServiceImpl implements UserBettingService {

	private UserBettingDAO userBettingDAO;
	private BettingCompetitionDAO bettingCompetitionDAO;
	private UserDAO userDAO;
	

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getUserPendingBets(long)
	 */
	public List<Bet> getUserPendingBets(long userId) {
		return userBettingDAO.getUserPendingBets(userId);
	}
	
	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createBet(com.doublelife.doublelife.data.BetComp.Bet)
	 */
	public boolean createBet(Bet bet) {
		return userBettingDAO.saveBet(bet);
	}
	
	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#processBetResults(com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public void processBetResults(BetEvent betEvent) {
		List<Bet> lstBets = userBettingDAO.getBetsByBetEvent(betEvent.getId());
		for (Bet thisBet : lstBets) {
			if (thisBet.getSelectionId() == betEvent.getSelectionWinnerId()) {
				thisBet.setBetResult(BetResult.WIN);
				double winnings = thisBet.getStake() * thisBet.getOdds();
				thisBet.setMoneyPaid(winnings);
				
				//update user account with winning amount
				updateUserBettingAccount(thisBet);
			} else {
				thisBet.setBetResult(BetResult.LOSE);
				thisBet.setMoneyPaid(thisBet.getStake() * -1);
			}
			userBettingDAO.updateAllBets(lstBets);
		}
	}
	
	/**
	 * @return the userBettingDAO
	 */
	public UserBettingDAO getUserBettingDAO() {
		return userBettingDAO;
	}
	/**
	 * @param userBettingDAO the userBettingDAO to set
	 */
	public void setUserBettingDAO(UserBettingDAO userBettingDAO) {
		this.userBettingDAO = userBettingDAO;
	}
	
	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#addBettingParticipant(com.doublelife.doublelife.data.BetComp.BetParticipant)
	 */
	public void addBettingParticipant(BetParticipant betParticipant) {
		userBettingDAO.createBetParticipant(betParticipant);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#addBetEvent(com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public boolean createBetEvent(BetEvent betEvent) {
		return userBettingDAO.createBetEvent(betEvent);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#addUserBettingAccount(com.doublelife.doublelife.data.User)
	 */
	public UserBettingAccount addUserBettingAccount(final User user) {
		UserBettingAccount userBettingAccount = new UserBettingAccount();
		userBettingAccount.setAmountAvailable(0.00);
		userBettingAccount.setDateUpdated(new Date());
		userBettingAccount.setUserId(user.getId());
		
		userBettingDAO.createUserBettingAccount(userBettingAccount);
		
		return userBettingAccount;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#addBetEventType(com.doublelife.doublelife.data.BetComp.BetEventType)
	 */
	public void addBetEventType(BetEventType betEventType) {
		userBettingDAO.createBetEventType(betEventType);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#updateUserBettingAccount(long)
	 */
	public boolean updateUserBettingAccount(Bet bet) {
		UserBettingAccount userAcct = userBettingDAO.getUserBettingAccountByUserId(bet.getUserId(), bet.getCompId());
		if (userAcct != null) {
			userAcct.setAmountAvailable(userAcct.getAmountAvailable() + bet.getMoneyPaid());
			userAcct.setDateUpdated(new Date());
			return userBettingDAO.updateUserBettingAccount(userAcct);
		}
		return false;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getAllUserBets(long)
	 */
	public List<Bet> getAllUserBets(long userId) {
		return userBettingDAO.getAllUserBets(userId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getUserBettingAccount(long)
	 */
	public UserBettingAccount getUserBettingAccount(long userId, long compId) {
		return userBettingDAO.getUserBettingAccountByUserId(userId, compId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getAllCurrentCompetitions()
	 */
	public List<BetCompetition> getAllCurrentCompetitions() {
		return userBettingDAO.getAllCurrentCompetitions();
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getCompetitionById(long)
	 */
	public BetCompetition getCompetitionById(long id) {
		return userBettingDAO.getCompetitionById(id);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createBetCompetition(com.doublelife.doublelife.data.BetComp.BetCompetition)
	 */
	public boolean createBetCompetition(BetCompetition betCompetition) {
		return userBettingDAO.createBetCompetition(betCompetition);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getAllCurrentBetEvents()
	 */
	public Set<BetEvent> getAllCurrentBetEvents() {
		return userBettingDAO.getAllCurrentBetEvents();
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getBetEventById(long)
	 */
	public BetEvent getBetEventById(long betEventId) {
		return userBettingDAO.getBetEventById(betEventId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getBetEventParticipantPricesByEvent(long)
	 */
	public List<BetEventParticipantPrice> getBetEventParticipantPricesByEvent(
			long betEventId) {
		return userBettingDAO.getBetEventParticipantPricesByEvent(betEventId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getMappedParticipantAndPrice(com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public Map<BetParticipant, Double> getMappedParticipantAndPrice(BetEvent betEvent) {
		Map<BetParticipant, Double> mapParticipantNameToPrice = new HashMap<BetParticipant, Double>();
		List<BetEventParticipantPrice> bettingPrices = getBetEventParticipantPricesByEvent(betEvent.getId());
		for (BetParticipant thisParticipant : betEvent.getLstBetParticipant()) {
			for (BetEventParticipantPrice thisBetPrice : bettingPrices) {
				if (thisBetPrice.getBetParticipantId() == thisParticipant.getId()) {
					mapParticipantNameToPrice.put(thisParticipant, thisBetPrice.getOdds());
				}
			}
		}
		return mapParticipantNameToPrice;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createAndSaveBet(long, long)
	 */
	public boolean createAndSaveBet(long betEventId, long selectionId, double stake, double odds) {
		Bet bet = new Bet();
		bet.setBetEventId(betEventId);
		bet.setBetResult(BetResult.PENDING);
		bet.setUserId(SecurityUtil.getCurrentUserId());
		bet.setDateReceived(new Date());
		bet.setStake(stake);
		bet.setSelectionId(selectionId);
		bet.setOdds(odds);
		bet.setMoneyPaid(-1.00 * stake);
		bet.setCompId(1);  //TODO: grab competition id!
		if (createBet(bet)) {
			return updateUserBettingAccount(bet);
		} else {
			return false;
		}
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getMappedBetAndSelection()
	 */
	public Map<Bet, String> getMappedBetAndSelection() {
		Map<Bet, String> mapBetsAndSelections = new HashMap<Bet, String>();
		List<Bet> lstBets = getAllUserBets(SecurityUtil.getCurrentUserId());
		Set<BetParticipant> setParticipants = userBettingDAO.getParticipantsBySelectionList(getSelectionIdsFromBets(lstBets));
		for(Bet thisBet : lstBets) {
			for (BetParticipant thisParticipant : setParticipants) {
				if (thisParticipant.getId() == thisBet.getSelectionId()) {
					mapBetsAndSelections.put(thisBet, thisParticipant.getName());
				}
			}
		}
		return mapBetsAndSelections;
	}
	
	private List<Long> getSelectionIdsFromBets(List<Bet> lstBets) {
		List<Long> lstSelectionIds = new ArrayList<Long>(); 
		for(Bet thisBet : lstBets) {
			lstSelectionIds.add(thisBet.getSelectionId());
		}
		return lstSelectionIds;
	}
	
	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createNewBettingAccount(com.doublelife.doublelife.data.BetComp.BetCompetition, long)
	 */
	public void createNewBettingAccount(BetCompetition betComp, long userId) {
		UserBettingAccount userBetAcct = new UserBettingAccount();
		userBetAcct.setAmountAvailable(betComp.getAcctStartAmnt());
		userBetAcct.setCompId(betComp.getId());
		userBetAcct.setUserId(userId);
		userBettingDAO.createUserBettingAccount(userBetAcct);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getAllBetParticipants()
	 */
	public List<BetParticipant> getAllBetParticipants() {
		return userBettingDAO.getAllBetParticipants();
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getAllBetEventTypes()
	 */
	public List<BetEventType> getAllBetEventTypes() {
		return userBettingDAO.getAllBetEventTypes();
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getParticipantById(long)
	 */
	public BetParticipant getParticipantById(long id) {
		return userBettingDAO.getParticipantById(id);
	}

	/**
	 * @return the bettingCompetitionDAO
	 */
	public BettingCompetitionDAO getBettingCompetitionDAO() {
		return bettingCompetitionDAO;
	}

	/**
	 * @param bettingCompetitionDAO the bettingCompetitionDAO to set
	 */
	public void setBettingCompetitionDAO(BettingCompetitionDAO bettingCompetitionDAO) {
		this.bettingCompetitionDAO = bettingCompetitionDAO;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createBetEventParticipantPrice(com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice)
	 */
	public boolean createBetEventParticipantPrice(
			BetEventParticipantPrice betEventParticipantPrice) {
		return userBettingDAO.createBetEventParticipantPrice(betEventParticipantPrice);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createAllBetEventParticipantPrices(com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public void createAllBetEventParticipantPrices(BetEvent betEvent) {
		for (BetEventParticipantPrice thisParticipantPrice : betEvent.getLstBetEventParticipantPrice()) {
			thisParticipantPrice.setBetEventId(betEvent.getId());
			thisParticipantPrice.setBetParticipantId(thisParticipantPrice.getBetParticipant().getId());
			thisParticipantPrice.setIsCurrent(true);
			userBettingDAO.createBetEventParticipantPrice(thisParticipantPrice);
		}
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getLeaderBoardForCompetition(long)
	 */
	public Map<User, Double> getLeaderBoardForCompetition(
			long betttingCompetitionId) {
		Map<User, Double> mapUserLeaderboard = new HashMap<User, Double>();
		
		List<UserBettingAccount> lstUserBettingAccount = userBettingDAO.getLstUserBettingAccountByCompId(betttingCompetitionId);
		Collections.sort(lstUserBettingAccount);
		
		for (UserBettingAccount thisUserAct : lstUserBettingAccount) {
			User thisUser = userDAO.getUserById(thisUserAct.getUserId());
			mapUserLeaderboard.put(thisUser, thisUserAct.getAmountAvailable());
		}
		return mapUserLeaderboard;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createSeason(com.doublelife.doublelife.data.BetComp.Season)
	 */
	public boolean createSeason(Season season) {
		return userBettingDAO.createSeason(season);
	}
	
	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createRound(com.doublelife.doublelife.data.BetComp.Round)
	 */
	public boolean createRound(Round round) {
		return userBettingDAO.createRound(round);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getAllSeasons()
	 */
	public List<Season> getAllSeasons() {
		return userBettingDAO.getAllSeasons();
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getAllSeasonsByBetEventType(long)
	 */
	public List<Season> getAllSeasonsByBetEventType(long betEventType) {
		return userBettingDAO.getAllSeasonsByBetEventType(betEventType);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getSeasonById(long)
	 */
	public Season getSeasonById(long seasonId) {
		return userBettingDAO.getSeasonById(seasonId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getRoundsBySeasonId(long)
	 */
	public List<Round> getRoundsBySeasonId(long seasonId) {
		return userBettingDAO.getRoundsBySeasonId(seasonId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getRoundById(long)
	 */
	public Round getRoundById(long roundId) {
		return userBettingDAO.getRoundById(roundId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getBetEventsByRoundId(long)
	 */
	public List<BetEvent> getBetEventsByRoundId(long roundId) {
		return userBettingDAO.getBetEventsByRoundId(roundId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getBetEventTypeById(long)
	 */
	public BetEventType getBetEventTypeById(long betEventTypeId) {
		return userBettingDAO.getBetEventTypeById(betEventTypeId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#updateSubmittedBetPrices(java.lang.String, java.lang.String, com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public boolean updateSubmittedBetPrices(String idPrices, String betPrices,
			BetEvent betEvent) {
		
		String[] arrIdPrices = idPrices.split(",");
		String[] arrBetPrices = betPrices.split(",");
		boolean result = true;
		for(int i = 0; i < arrIdPrices.length; i++) {
			String[] thisBetPrice = arrIdPrices[i].split(":");
			if (!arrBetPrices[i].equals(thisBetPrice[1])) {
				//price has been updated

				BetEventParticipantPrice thisPrice = new BetEventParticipantPrice();
				thisPrice.setBetEventId(betEvent.getId());
				thisPrice.setBetParticipantId(Long.parseLong(thisBetPrice[0]));
				thisPrice.setOdds(Double.parseDouble(arrBetPrices[i]));
				thisPrice.setIsCurrent(true);
				result = userBettingDAO.createBetEventParticipantPrice(thisPrice);
			}
		}
		
		return result;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#updateBetEvent(com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public boolean updateBetEvent(BetEvent betEvent) {
		return userBettingDAO.updateBetEvent(betEvent);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getActiveRoundForComp(long)
	 */
	public Round getActiveRoundForComp(long seasonId) {
		return userBettingDAO.getActiveRoundForComp(seasonId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#getBetCompRulesByCompId(long)
	 */
	public BetCompRules getBetCompRulesByCompId(long compId) {
		return userBettingDAO.getBetCompRulesByCompId(compId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#createBetTip(com.doublelife.doublelife.data.BetComp.BetTip)
	 */
	public boolean createBetTip(BetTip betTip) {
		return userBettingDAO.createBetTip(betTip);
	}
}
