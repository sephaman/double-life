package com.doublelife.doublelife.data.asset.stocks;

import java.util.Date;

/**
 * Represents stock held by a user.
 * @author Joseph McAleer
 */
public class UserStockHolding {

	private String stockCode;
	private String stockName;
	private double costBasis;
	private long quantityHeld;
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
}
