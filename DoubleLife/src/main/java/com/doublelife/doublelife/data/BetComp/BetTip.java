package com.doublelife.doublelife.data.BetComp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a bet tip.
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet_tip")
public class BetTip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "bet_event_id")
	private long betEventId;
	
	@Column(name = "dateTime")
	private Date dateTime;
	
	@Column(name = "outcomePending")
	private Boolean isOutcomePending;
	
	@Column(name = "selectionId")
	private long selectionId;
	
	@Column(name = "parent_round_id")
	private long parentRoundId;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "compId")
	private long compId;

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
	 * @return the betEventId
	 */
	public long getBetEventId() {
		return betEventId;
	}

	/**
	 * @param betEventId the betEventId to set
	 */
	public void setBetEventId(long betEventId) {
		this.betEventId = betEventId;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the isOutcomePending
	 */
	public Boolean getIsOutcomePending() {
		return isOutcomePending;
	}

	/**
	 * @param isOutcomePending the isOutcomePending to set
	 */
	public void setIsOutcomePending(Boolean isOutcomePending) {
		this.isOutcomePending = isOutcomePending;
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
	 * @return the parentRoundId
	 */
	public long getParentRoundId() {
		return parentRoundId;
	}

	/**
	 * @param parentRoundId the parentRoundId to set
	 */
	public void setParentRoundId(long parentRoundId) {
		this.parentRoundId = parentRoundId;
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
	 * @return the compId
	 */
	public long getCompId() {
		return compId;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(long compId) {
		this.compId = compId;
	}
	
	
	
}
