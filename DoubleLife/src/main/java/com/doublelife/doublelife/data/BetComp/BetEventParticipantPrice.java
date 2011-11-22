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
@Entity (name = "bet_participant_price")
public class BetEventParticipantPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "participantid")
	private long participantId;
	
	@Column(name = "odds", nullable = false)
	private double odds;
	
	@Column(name = "update_datetime", nullable = false)
	private Date dateUpdated;
	
	@Column(name = "beteventid", nullable = false)
	private long betEventId;
	
	@Column(name="is_current", nullable = false)
	private Boolean isCurrent;

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
	 * @param dateUpdated the dateUpdated to set
	 */
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	/**
	 * @return the dateUpdated
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}
	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}
	/**
	 * @return the participantId
	 */
	public long getParticipantId() {
		return participantId;
	}
	/**
	 * @param isCurrent the isCurrent to set
	 */
	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	/**
	 * @return the isCurrent
	 */
	public Boolean getIsCurrent() {
		return isCurrent;
	}
	
}
