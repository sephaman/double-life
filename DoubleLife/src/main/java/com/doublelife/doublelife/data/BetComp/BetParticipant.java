/**
 * 
 */
package com.doublelife.doublelife.data.BetComp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Represents a participant in a bet event (team / player etc)
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet_participant")
public class BetParticipant {

	@Id
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "updateDateTime", nullable = false)
	private Date updateDateTime;
	
	@Column(name = "primaryBetEventTypeId", nullable = false)
	private long primaryBetEventTypeId;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the updateDateTime
	 */
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the primaryBetEventTypeId
	 */
	public long getPrimaryBetEventTypeId() {
		return primaryBetEventTypeId;
	}

	/**
	 * @param primaryBetEventTypeId the primaryBetEventTypeId to set
	 */
	public void setPrimaryBetEventTypeId(long primaryBetEventTypeId) {
		this.primaryBetEventTypeId = primaryBetEventTypeId;
	}
}
