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
 * Represents a season or collection of sporting events.
 * @author Joseph McAleer
 *
 */
@Entity (name = "season")
public class Season {

	
	/**
	 * Default constructor.
	 */
	public Season() {
		
	}
	
	/**
	 * Convenient constructor to create a season.
	 * Initially developed to create a mock season not intended to be persisted to represent 'none'.
	 * @param id
	 * @param seasonName
	 */
	public Season(long id, String seasonName) {
		this.id = id;
		this.seasonName = seasonName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "beteventtypeid")
	private long betEventTypeId;
	
	@Column(name = "seasonName")
	private String seasonName;
	
	@Column(name = "updateDateTime")
	private Date updateDateTime;
	
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
	 * @return the betEventTypeId
	 */
	public long getBetEventTypeId() {
		return betEventTypeId;
	}

	/**
	 * @param betEventTypeId the betEventTypeId to set
	 */
	public void setBetEventTypeId(long betEventTypeId) {
		this.betEventTypeId = betEventTypeId;
	}

	/**
	 * @return the seasonName
	 */
	public String getSeasonName() {
		return seasonName;
	}

	/**
	 * @param seasonName the seasonName to set
	 */
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
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

}
