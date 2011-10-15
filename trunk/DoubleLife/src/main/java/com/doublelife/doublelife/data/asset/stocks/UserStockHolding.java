package com.doublelife.doublelife.data.asset.stocks;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


/**
 * Represents stock held by a user.
 * @author Joseph McAleer
 */
@Entity (name = "userstock")
public class UserStockHolding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "userId", nullable = false)
	private long userId;
	
	@Column(name = "stockCode", nullable = false)
	private String stockCode;
	
	@Transient
	private String stockName;
	
	@Column(name = "costBasis", nullable = false)
	private double costBasis;
	
	@Column(name = "quantityHeld", nullable = false)
	private long quantityHeld;
	
	@Column(name = "dateAcquired", nullable = false)
	private Date dateAcquired;
	
	@Column(name = "is_active", nullable = false)
	private int isActive;
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getCostBasis() {
		return costBasis;
	}
	public void setCostBasis(double costBasis) {
		this.costBasis = costBasis;
	}
	public long getQuantityHeld() {
		return quantityHeld;
	}
	public void setQuantityHeld(long quantityHeld) {
		this.quantityHeld = quantityHeld;
	}
	public Date getDateAcquired() {
		return dateAcquired;
	}
	public void setDateAcquired(Date dateAcquired) {
		this.dateAcquired = dateAcquired;
	}
	public int isActive() {
		return isActive;
	}
	public void setActive(int isActive) {
		this.isActive = isActive;
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
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
}
