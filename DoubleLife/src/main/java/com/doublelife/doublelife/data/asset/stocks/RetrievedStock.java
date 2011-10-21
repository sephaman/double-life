package com.doublelife.doublelife.data.asset.stocks;

/**
 * Represents a stock retrieved from a real time market source.
 * @author Joseph McAleer
 *
 */
public class RetrievedStock {

	private double currentPrice;
	private String stockCode;
	private String stockName;
	
	/**
	 * @return
	 */
	public double getCurrentPrice() {
		return currentPrice;
	}
	/**
	 * @param currentPrice
	 */
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	/**
	 * @return
	 */
	public String getStockCode() {
		return stockCode;
	}
	/**
	 * @param stockCode
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	/**
	 * @return
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * @param stockName
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
}
