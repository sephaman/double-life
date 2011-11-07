/**
 * 
 */
package com.doublelife.doublelife.data.BetComp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToMany(fetch = FetchType.EAGER)
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
	
	@Column(name = "is_active")
	private int isActive;
	
	@Column(name = "created_by_userid")
	private long createdByUserId;
	
	@Column(name = "acct_start_amnt")
	private double acctStartAmnt;
	
	@Column(name = "end_date")
	private Date endDate;

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
		if (lstUser == null) {
			lstUser = new ArrayList<User>();
		}
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

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isActive
	 */
	public int getIsActive() {
		return isActive;
	}

	/**
	 * @param createdByUserId the createdByUserId to set
	 */
	public void setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	/**
	 * @return the createdByUserId
	 */
	public long getCreatedByUserId() {
		return createdByUserId;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param acctStartAmnt the acctStartAmnt to set
	 */
	public void setAcctStartAmnt(double acctStartAmnt) {
		this.acctStartAmnt = acctStartAmnt;
	}

	/**
	 * @return the acctStartAmnt
	 */
	public double getAcctStartAmnt() {
		return acctStartAmnt;
	}
}
