package com.doublelife.doublelife.dao;

/**
 * Represents a stock.
 * @author sepha
 *
 */
public class Stock {

	private String stockCode;
	private double currentPrice;
	private String stockName;

	/**
	 * Get the stock code.
	 * @return
	 */
	public String getStockCode() {
		return stockCode;
	}

	/**
	 * Set the stock code.
	 * @param stockCode
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	/**
	 * Get the stock name.
	 * @return
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * Set the stock name.
	 * @param stockName
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * Gets the currentPrice of the stock.
	 * @return currentPrice.
	 */
	public Double getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * Sets the current price of the stock.
	 * @param currentPrice
	 */
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	
	
	
}
