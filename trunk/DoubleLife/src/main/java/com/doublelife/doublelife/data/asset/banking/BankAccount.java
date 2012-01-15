/**
 * 
 */
package com.doublelife.doublelife.data.asset.banking;

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
 * @author Joseph McAleer
 *
 */
@Entity (name = "bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToMany
	@JoinTable (
	name = "acct_user",
	joinColumns = {@JoinColumn(name = "acctId")} ,
	inverseJoinColumns ={@JoinColumn(name = "userId")} 
	)
	private List<User> lstUser;	 //could be multiple users sharing an account
	
	@Column(name = "compId", nullable = false)
	private long compId;
	
	@Column(name = "bank_acct_type", nullable = false)
	private BankAccountType bankAccountType;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@Column(name = "acct_start_date")
	private Date compStartDate;
	
	@Column(name = "update_dateTime")
	private Date updateDateTime;

	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "created_by_userid")
	private long createdByUserId;
	
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
	 * @return the compId
	 */
	public long getCompId() {
		return compId;
	}
	/**
	 * @param compId the compId to set
	 */
	public void setCompId(long compId) {
		this.compId = compId;
	}
	/**
	 * @return the bankAccountType
	 */
	public BankAccountType getBankAccountType() {
		return bankAccountType;
	}
	/**
	 * @param bankAccountType the bankAccountType to set
	 */
	public void setBankAccountType(BankAccountType bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @param lstUser the lstUser to set
	 */
	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}
	/**
	 * @return the lstUser
	 */
	public List<User> getLstUser() {
		return lstUser;
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
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the createdByUserId
	 */
	public long getCreatedByUserId() {
		return createdByUserId;
	}
	/**
	 * @param createdByUserId the createdByUserId to set
	 */
	public void setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	
	
	
}
