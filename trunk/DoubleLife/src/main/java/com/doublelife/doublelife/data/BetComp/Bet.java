package com.doublelife.doublelife.data.BetComp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a single bet made by a user.
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet")
public class Bet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "odds", nullable = false)
	private double odds;
	
	@Column(name = "dateReceived", nullable = false)
	private Date dateReceived;
	
	@Column(name = "stake", nullable = false)
	private double stake;
	
	@Column(name = "selectionid", nullable = false)
	private long selectionId;
	
	@Column(name = "betResult", nullable = false)
	private BetResult betResult;
	
	@Column(name = "moneyPaid", nullable = false)
	private double moneyPaid;
	
	@Column(name = "bet_event_id", nullable = false)
	private long betEventId;
	
	@Column(name = "compid", nullable = false)
	private long compId;

	
	/**
	 * @return the user
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId 
	 * @param user the user to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
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
	 * @return the selectionId
	 */
	public long getSelectionId() {
		return selectionId;
	}
	/**
	 * @param selectionId the selectionId to set
	 */
	public void setSelectionId(long selectionId) {
		this.selectionId = selectionId;
	}
	/**
	 * @param betResult the betResult to set
	 */
	public void setBetResult(BetResult betResult) {
		this.betResult = betResult;
	}
	/**
	 * @return the betResult
	 */
	public BetResult getBetResult() {
		return betResult;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param stake the stake to set
	 */
	public void setStake(double stake) {
		this.stake = stake;
	}
	/**
	 * @return the stake
	 */
	public double getStake() {
		return stake;
	}
	/**
	 * @param moneyPaid the moneyPaid to set
	 */
	public void setMoneyPaid(double moneyPaid) {
		this.moneyPaid = moneyPaid;
	}
	/**
	 * @return the moneyPaid
	 */
	public double getMoneyPaid() {
		return moneyPaid;
	}
	/**
	 * @param betEventId the betEventId to set
	 */
	public void setBetEventId(long betEventId) {
		this.betEventId = betEventId;
	}
	/**
	 * @return the betEventId
	 */
	public long getBetEventId() {
		return betEventId;
	}
	/**
	 * @param odds the odds to set
	 */
	public void setOdds(double odds) {
		this.odds = odds;
	}
	/**
	 * @return the odds
	 */
	public double getOdds() {
		return odds;
	}
	/**
	 * @param compId the compId to set
	 */
	public void setCompId(long compId) {
		this.compId = compId;
	}
	/**
	 * @return the compId
	 */
	public long getCompId() {
		return compId;
	}
	
}
