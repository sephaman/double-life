package com.doublelife.doublelife.data.BetComp;

import java.util.Date;

import com.doublelife.doublelife.data.User;

/**
 * Represents a single bet made by a user.
 * @author Joseph McAleer
 *
 */
public class Bet {

	private User user;
	private OddsRatio odds; 
	private BetEvent betEvent;
	private Date dateReceived;
	private boolean userWins;
	private double userStake;
	private boolean pending;
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the odds
	 */
	public OddsRatio getOdds() {
		return odds;
	}
	/**
	 * @param odds the odds to set
	 */
	public void setOdds(OddsRatio odds) {
		this.odds = odds;
	}
	/**
	 * @return the betEvent
	 */
	public BetEvent getBetEvent() {
		return betEvent;
	}
	/**
	 * @param betEvent the betEvent to set
	 */
	public void setBetEvent(BetEvent betEvent) {
		this.betEvent = betEvent;
	}
	/**
	 * @return the dateReceived
	 */
	public Date getDateReceived() {
		return dateReceived;
	}
	/**
	 * @param dateReceived the dateReceived to set
	 */
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	/**
	 * @return the userWins
	 */
	public boolean isUserWins() {
		return userWins;
	}
	/**
	 * @param userWins the userWins to set
	 */
	public void setUserWins(boolean userWins) {
		this.userWins = userWins;
	}
	/**
	 * @return the userStake
	 */
	public double getUserStake() {
		return userStake;
	}
	/**
	 * @param userStake the userStake to set
	 */
	public void setUserStake(double userStake) {
		this.userStake = userStake;
	}
	/**
	 * @return the pending
	 */
	public boolean isPending() {
		return pending;
	}
	/**
	 * @param pending the pending to set
	 */
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	
}
