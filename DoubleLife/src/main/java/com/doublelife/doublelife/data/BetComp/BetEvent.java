package com.doublelife.doublelife.data.BetComp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable (
	name = "participant_betevent",
	joinColumns = {@JoinColumn(name = "betEventId")} ,
	inverseJoinColumns ={@JoinColumn(name = "participantId")}
	)
	private List<BetParticipant> lstBetParticipant;
	
	@Column(name = "outcomePending")
	private Boolean isOutcomePending;
	
	@Column(name = "selectionWinnerId")
	private long selectionWinnerId;
	
	@Column(name = "bet_event_name")
	private String betEventName;
	
	@Column(name = "parent_round_id")
	private long parentRoundId;
	
	@Transient
	private List<BetEventParticipantPrice> lstBetEventParticipantPrice;

	/**
	 * @return the lstBetEventParticipantPrice
	 */
	public List<BetEventParticipantPrice> getLstBetEventParticipantPrice() {
		if (lstBetEventParticipantPrice == null) {
			lstBetEventParticipantPrice = new ArrayList<BetEventParticipantPrice>();
		}
		return lstBetEventParticipantPrice;
	}

	/**
	 * @param lstBetEventParticipantPrice the lstBetEventParticipantPrice to set
	 */
	public void setLstBetEventParticipantPrice(
			List<BetEventParticipantPrice> lstBetEventParticipantPrice) {
		this.lstBetEventParticipantPrice = lstBetEventParticipantPrice;
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
	public Boolean isOutcomePending() {
		return isOutcomePending;
	}
	/**
	 * @param isOutcomePending the isOutcomePending to set
	 */
	public void setOutcomePending(Boolean isOutcomePending) {
		this.isOutcomePending = isOutcomePending;
	}
	
	
	/**
	 * Returns true if there are more than two competing entities.
	 * @return
	 */
	public boolean isMoreThanTwoCompetitors() {
		return lstBetParticipant.size() > 2;
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
	/**
	 * @param lstBetParticipant the lstBetParticipant to set
	 */
	public void setLstBetParticipant(List<BetParticipant> lstBetParticipant) {
		this.lstBetParticipant = lstBetParticipant;
	}
	/**
	 * @return the lstBetParticipant
	 */
	public List<BetParticipant> getLstBetParticipant() {
		if (lstBetParticipant == null) {
			lstBetParticipant = new ArrayList<BetParticipant>();
		} 
		return lstBetParticipant;
	}
	
	/**
	 * @param betEventName the betEventName to set
	 */
	public void setBetEventName(String betEventName) {
		this.betEventName = betEventName;
	}
	/**
	 * @return the betEventName
	 */
	public String getBetEventName() {
		return betEventName;
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
}
