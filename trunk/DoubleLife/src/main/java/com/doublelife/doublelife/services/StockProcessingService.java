/**
 * 
 */
package com.doublelife.doublelife.services;

import com.doublelife.doublelife.data.asset.stocks.StockOrder;

/**
 * Interface for processing stocks. Manages other stock dealing services.
 * @author Joseph McAleer
 *
 */
public interface StockProcessingService {

	/**
	 * Service method that will periodically check pending stocks.
	 * Retrieves prices live via webservice.
	 * @return
	 */
	public int checkAndProcessPendingStocksLivePrices();
	
	public void processAtmarketPriceStockOrder(StockOrder stockOrder);
}
