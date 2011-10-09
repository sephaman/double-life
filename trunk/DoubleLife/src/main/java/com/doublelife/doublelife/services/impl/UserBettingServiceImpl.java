/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.dao.UserBettingDAO;
import com.doublelife.doublelife.services.UserBettingService;

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

}
