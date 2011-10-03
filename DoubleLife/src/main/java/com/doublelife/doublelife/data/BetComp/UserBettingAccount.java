/**
 * 
 */
package com.doublelife.doublelife.data.BetComp;

import com.doublelife.doublelife.data.User;

/**
 * Represents a user's betting account.
 * @author Joseph McAleer
 *
 */
public class UserBettingAccount {

	private User user;
	private Double amountAvailable;
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
	 * @return the amountAvailable
	 */
	public Double getAmountAvailable() {
		return amountAvailable;
	}
	/**
	 * @param amountAvailable the amountAvailable to set
	 */
	public void setAmountAvailable(Double amountAvailable) {
		this.amountAvailable = amountAvailable;
	}
	
}
