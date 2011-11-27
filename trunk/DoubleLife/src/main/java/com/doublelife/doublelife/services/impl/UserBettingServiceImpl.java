/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.doublelife.doublelife.data.BetComp.BetResult;
import com.doublelife.doublelife.data.BetComp.UserBettingAccount;
import com.doublelife.doublelife.data.dao.UserBettingDAO;
import com.doublelife.doublelife.services.UserBettingService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Implementation of the UserBetting Service.
 * @author Joseph McAleer
 *
 */
public class UserBettingServiceImpl implements UserBettingService {

	private UserBettingDAO userBettingDAO;
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
	 * @see com.doublelife.doublelife.services.UserBettingService#addBettingParticipant(com.doublelife.doublelife.data.BetComp.BetParticipant)
	 */
	public void addBettingParticipant(BetParticipant betParticipant) {
		userBettingDAO.createBetParticipant(betParticipant);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#addParticipantToBettingEvent(com.doublelife.doublelife.data.BetComp.BetParticipant, com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public void addParticipantToBettingEvent(BetParticipant betParticipant,
			BetEvent betEvent) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see com.doublelife.doublelife.services.UserBettingService#addBetEvent(com.doublelife.doublelife.data.BetComp.BetEvent)
	 */
	public void addBetEvent(BetEvent betEvent) {
		userBettingDAO.createBetEvent(betEvent);
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
			return userBettingDAO.createUserBettingAccount(userAcct);  //saves it
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
				if (thisBetPrice.getParticipantId() == thisParticipant.getId()) {
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

}
