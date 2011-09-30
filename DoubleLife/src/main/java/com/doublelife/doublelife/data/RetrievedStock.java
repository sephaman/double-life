package com.doublelife.doublelife.data;

/**
 * Represents a stock retrieved from a real time market source.
 * @author Joseph McAleer
 *
 */
public class RetrievedStock {

	private double currentPrice;
	private String stockCode;
	private String stockName;
	
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
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
}
