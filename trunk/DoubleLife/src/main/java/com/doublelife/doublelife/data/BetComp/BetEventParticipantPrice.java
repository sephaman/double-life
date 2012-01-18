package com.doublelife.doublelife.data.BetComp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Represents a single bet made by a user.
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet_participant_price")
public class BetEventParticipantPrice {

	/**
	 * Default constructor.
	 */
	public BetEventParticipantPrice() {
		
	}
	
	/**
	 * Constructor to allow initial building with BetParticipant and Odds
	 * @param betParticipant
	 * @param odds
	 */
	public BetEventParticipantPrice(BetParticipant betParticipant, Double odds) {
		this.betParticipant = betParticipant;
		this.odds = odds;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "participantid")
	private long betParticipantId;
	
	@Transient
	private BetParticipant betParticipant;  //don't persist directly
	
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
	 * @return the betParticipant
	 */
	public BetParticipant getBetParticipant() {
		return betParticipant;
	}
	/**
	 * @param betParticipant the betParticipant to set
	 */
	public void setBetParticipant(BetParticipant betParticipant) {
		this.betParticipant = betParticipant;
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
	
	public String toString() {
		return this.betParticipant.getName() + " - " + this.getOdds();
	}
	/**
	 * @return the betParticipantId
	 */
	public long getBetParticipantId() {
		return betParticipantId;
	}
	/**
	 * @param betParticipantId the betParticipantId to set
	 */
	public void setBetParticipantId(long betParticipantId) {
		this.betParticipantId = betParticipantId;
	}
	
}
