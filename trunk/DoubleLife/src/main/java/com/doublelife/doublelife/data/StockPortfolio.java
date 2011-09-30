/**
 * 
 */
package com.doublelife.doublelife.data;

import java.util.List;

import com.doublelife.doublelife.UserStockHolding;

/**
 * Represents a stock portfolio that contains information for all stocks held.
 * @author Joseph McAleer
 *
 */
public class StockPortfolio extends AbstractAsset {

	private List<UserStockHolding> lstStocks;

	public List<UserStockHolding> getLstStocks() {
		return lstStocks;
	}

	public void setLstStocks(List<UserStockHolding> lstStocks) {
		this.lstStocks = lstStocks;
	}
}
