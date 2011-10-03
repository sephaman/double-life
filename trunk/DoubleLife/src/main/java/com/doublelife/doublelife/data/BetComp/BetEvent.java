package com.doublelife.doublelife.data.BetComp;

import java.util.Date;
import java.util.List;

/**
 * Represents a bet event such as a sport.
 * @author Joseph McAleer
 *
 */
public class BetEvent {

	private BetEventType eventType;  //store in database
	private Date dateTime;
	private List<String> lstCompetitors;  //may not belong here
	private boolean isOutcomePending;
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
	 * @return the lstCompetitors
	 */
	public List<String> getLstCompetitors() {
		return lstCompetitors;
	}
	/**
	 * @param lstCompetitors the lstCompetitors to set
	 */
	public void setLstCompetitors(List<String> lstCompetitors) {
		this.lstCompetitors = lstCompetitors;
	}
	
	/**
	 * Returns true if there are more than two competing entities.
	 * @return
	 */
	public boolean isMoreThanTwoCompetitors() {
		return lstCompetitors.size() > 2;
	}
}
