/**
 * 
 */
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

import com.doublelife.doublelife.data.User;

/**
 * Represents a betting competition.
 * @author Joseph McAleer
 *
 */
@Entity (name = "bet_competition")
public class BetCompetition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable (
	name = "betcomp_user",
	joinColumns = {@JoinColumn(name = "betCompId")} ,
	inverseJoinColumns ={@JoinColumn(name = "userId")}
	)
	private List<User> lstUser;
	
	@Column(name = "comp_start_date")
	private Date compStartDate;
	
	@Column(name = "update_dateTime")
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
	 * @return the lstUser
	 */
	public List<User> getLstUser() {
		return lstUser;
	}

	/**
	 * @param lstUser the lstUser to set
	 */
	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}

	/**
	 * @return the compStartDate
	 */
	public Date getCompStartDate() {
		return compStartDate;
	}

	/**
	 * @param compStartDate the compStartDate to set
	 */
	public void setCompStartDate(Date compStartDate) {
		this.compStartDate = compStartDate;
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
