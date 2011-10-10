package com.doublelife.doublelife.data.BetComp;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Represents a bet event such as a sport.
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet_event")
public class BetEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "betEventTypeId")
	private long betEventTypeId;
	
	@Column(name = "dateTime")
	private Date dateTime;
	
	@Transient
	private List<Long> lstBetParticipantIds;  //may not belong here
	
	@Column(name = "outcomePending")
	private boolean isOutcomePending;
	
	@Column(name = "selectionWinnerId")
	private long selectionWinnerId;

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
	public boolean isOutcomePending() {
		return isOutcomePending;
	}
	/**
	 * @param isOutcomePending the isOutcomePending to set
	 */
	public void setOutcomePending(boolean isOutcomePending) {
		this.isOutcomePending = isOutcomePending;
	}
	
	
	/**
	 * Returns true if there are more than two competing entities.
	 * @return
	 */
	public boolean isMoreThanTwoCompetitors() {
		return lstBetParticipantIds.size() > 2;
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
	 * @param selectionWinnerId the selectionWinnerId to set
	 */
	public void setSelectionWinnerId(long selectionWinnerId) {
		this.selectionWinnerId = selectionWinnerId;
	}
	/**
	 * @return the selectionWinnerId
	 */
	public long getSelectionWinnerId() {
		return selectionWinnerId;
	}
	/**
	 * @param lstBetParticipantIds the lstBetParticipantIds to set
	 */
	public void setLstBetParticipantIds(List<Long> lstBetParticipantIds) {
		this.lstBetParticipantIds = lstBetParticipantIds;
	}
	/**
	 * @return the lstBetParticipantIds
	 */
	public List<Long> getLstBetParticipantIds() {
		return lstBetParticipantIds;
	}
	/**
	 * @param betEventTypeId the betEventTypeId to set
	 */
	public void setBetEventTypeId(long betEventTypeId) {
		this.betEventTypeId = betEventTypeId;
	}
	/**
	 * @return the betEventTypeId
	 */
	public long getBetEventTypeId() {
		return betEventTypeId;
	}
}
