package com.doublelife.doublelife.data.asset.stocks;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Represents stock held by a user.
 * @author Joseph McAleer
 */
@Entity (name = "userstock")
public class UserStockHolding {

	@Id
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "stockCode", nullable = false)
	private String stockCode;
	
	private String stockName;
	
	@Column(name = "costBasis", nullable = false)
	private double costBasis;
	
	@Column(name = "quantityHeld", nullable = false)
	private long quantityHeld;
	
	@Column(name = "dateAcquired", nullable = false)
	private Date dateAcquired;
	
	private boolean isActive;
	
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
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
}
