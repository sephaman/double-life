/**
 * 
 */
package com.doublelife.doublelife.data.asset.stocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.doublelife.doublelife.data.asset.AbstractAsset;

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
	
	/**
	 * Returns the list of stock codes from this portfolio.
	 * @return
	 */
	public List<String> getPortfolioStockCodes() {
		List<String> lstStockCodes = new ArrayList<String>();
		for (UserStockHolding thisStock : getLstStocks()) {
			lstStockCodes.add(thisStock.getStockCode());
		}
		return lstStockCodes;
	}
	
	/**
	 * Gets the stock holdings mapped to it's code for easy reference.
	 * @return
	 */
	public Map<String, UserStockHolding> getHoldingsMappedToStockCode() {
		Map<String, UserStockHolding> mappedStocks = new HashMap<String, UserStockHolding>();
		for (UserStockHolding thisStockHolding : getLstStocks()) {
			mappedStocks.put(thisStockHolding.getStockCode(), thisStockHolding);
		}
		return mappedStocks;
	}
}
