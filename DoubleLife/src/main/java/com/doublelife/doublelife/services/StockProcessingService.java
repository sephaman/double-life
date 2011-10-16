/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.Map;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.StockPortfolio;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;

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
	
	/**
	 * Processes the stockorder at the current market price.
	 * @param stockOrder
	 * @return 
	 */
	public boolean processAtMarketPriceStockOrder(StockOrder stockOrder);
	
	/**
	 * Get a users stock portfolio.
	 * @param userId
	 * @return
	 */
	public StockPortfolio getUserStockPortfolio(long userId);
	
	/**
	 * Returns a map of a user's stocks with equivalent live stocks.
	 * @param userId 
	 * @return
	 */
	public Map<UserStockHolding, RetrievedStock> getUserLiveStockMappings(long userId);
			
}
