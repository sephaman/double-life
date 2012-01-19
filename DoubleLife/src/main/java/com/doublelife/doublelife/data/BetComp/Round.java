/**
 * 
 */
package com.doublelife.doublelife.data.BetComp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a round which is a collection of bet events.
 * @author Joseph McAleer
 *
 */
@Entity (name = "round")
public class Round {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "seasonid")
	private long seasonid;
	
	@Column(name = "round_sequence_no")
	private long roundSequenceNumber;
	
	@Column(name = "roundname")
	private String roundName;

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
	 * @return the seasonid
	 */
	public long getSeasonid() {
		return seasonid;
	}

	/**
	 * @param seasonid the seasonid to set
	 */
	public void setSeasonid(long seasonid) {
		this.seasonid = seasonid;
	}

	/**
	 * @return the roundSequenceNumber
	 */
	public long getRoundSequenceNumber() {
		return roundSequenceNumber;
	}

	/**
	 * @param roundSequenceNumber the roundSequenceNumber to set
	 */
	public void setRoundSequenceNumber(long roundSequenceNumber) {
		this.roundSequenceNumber = roundSequenceNumber;
	}

	/**
	 * @return the roundName
	 */
	public String getRoundName() {
		return roundName;
	}

	/**
	 * @param roundName the roundName to set
	 */
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	
}
