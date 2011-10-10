package com.doublelife.doublelife.data.BetComp;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany
	@JoinTable (
	name = "participant_betevent",
	joinColumns = {@JoinColumn(name = "betEventId")} ,
	inverseJoinColumns ={@JoinColumn(name = "participantId")}
	)
	private List<BetParticipant> lstBetParticipant;
	
	@Column(name = "outcomePending")
	private int isOutcomePending;
	
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
	public int isOutcomePending() {
		return isOutcomePending;
	}
	/**
	 * @param isOutcomePending the isOutcomePending to set
	 */
	public void setOutcomePending(int isOutcomePending) {
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
		return lstBetParticipant;
	}
}
