/**
 * 
 */
package com.doublelife.doublelife.services.utils;

import java.util.ArrayList;
import java.util.List;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;

/**
 * Provides general utility methods for dealing with stocks.
 * @author Joseph McAleer
 *
 */
public class StockHelper {

	/**
	 * Extracts a list of stock codes from a list of stockorders.
	 * @param lstStockOrder
	 * @return
	 */
	public static List<String> getListStockCodesFromPendingStockOrders(List<StockOrder> lstStockOrder) {
		List<String> lstStockCodes = new ArrayList<String>();
		for (StockOrder stockOrder : lstStockOrder) {
			lstStockCodes.add(stockOrder.getStockCode());
		}
		return lstStockCodes;
	}
	
	/**
	 * Grabs the retrieved stock from a list by the goven stock code.
	 * @param lstRetrievedStock
	 * @param stockCode
	 * @return
	 */
	public static RetrievedStock getRetrievedStockByCode(List<RetrievedStock> lstRetrievedStock, String stockCode) {
		for (RetrievedStock thisStock : lstRetrievedStock) {
			if (thisStock.getStockCode().equalsIgnoreCase(stockCode)) {
				return thisStock;
			}
		}
		return null;
	}
}
