/**
 * 
 */
package com.doublelife.doublelife.data.BetComp;

import javax.persistence.Entity;


/**
 * Represents a BetEventType.
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet_event_type")
public class BetEventType {
	
	private long id;
	private String sportName;
	private String eventName;
	
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
	 * @return the sportName
	 */
	public String getSportName() {
		return sportName;
	}
	/**
	 * @param sportName the sportName to set
	 */
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
}
