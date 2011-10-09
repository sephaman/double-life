package com.doublelife.doublelife.data.BetComp;

import java.util.Date;
import java.util.List;

/**
 * Represents a bet event such as a sport.
 * @author Joseph McAleer
 *
 */
public class BetEvent {

	private long id;
	private BetEventType eventType;  //store in database
	private Date dateTime;
	private List<Long> lstBetParticipantIds;  //may not belong here
	private boolean isOutcomePending;
	private long selectionWinnerId;

	/**
	 * @return the eventType
	 */
	public BetEventType getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(BetEventType eventType) {
		this.eventType = eventType;
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
}
