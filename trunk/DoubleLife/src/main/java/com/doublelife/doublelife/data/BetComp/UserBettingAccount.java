/**
 * 
 */
package com.doublelife.doublelife.data.BetComp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a user's betting account.
 * @author Joseph McAleer
 *
 */
@Entity (name = "user_betting_account")
public class UserBettingAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "userId", nullable = false)
	private long userId;
	
	@Column(name = "amount", nullable = false)
	private Double amountAvailable;
	
	@Column(name = "updateDateTime", nullable = false)
	private Date updateDateTime;
	
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
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @param dateUpdated the dateUpdated to set
	 */
	public void setDateUpdated(Date dateUpdated) {
		this.updateDateTime = dateUpdated;
	}
	/**
	 * @return the dateUpdated
	 */
	public Date getDateUpdated() {
		return updateDateTime;
	}
	
}
