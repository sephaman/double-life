/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.dao.StockOrderDAO;
import com.doublelife.doublelife.services.StockProcessingService;
import com.doublelife.doublelife.services.StockService;
import com.doublelife.doublelife.services.UserStockService;
import com.doublelife.doublelife.services.utils.StockHelper;

/**
 * Implementation of StockProcessingService, providing services for processing stockorders.
 * @author Joseph McAleer
 *
 */
public class StockProcessingServiceImpl implements StockProcessingService {

	private final Logger logger = LoggerFactory.getLogger(StockProcessingServiceImpl.class);
	
	private UserStockService userStockService;
	private StockOrderDAO stockOrderDAO;
	private StockService stockService;
	
	//internal list to be refreshed. Shouldn't be accessible outside class.
	private List<RetrievedStock> lstRetrievedStock = new ArrayList<RetrievedStock>();
	
	/**
	 * @see com.doublelife.doublelife.services.StockProcessingService#checkAndProcessPendingStocks()
	 */
	public int checkAndProcessPendingStocksLivePrices() {
		int counter = 0;
		List<StockOrder> lstPendingStockOrders = stockOrderDAO.getAllPendingStockOrders();
		
		if (lstPendingStockOrders != null && lstPendingStockOrders.size() > 0) {
			//refresh retrieved stock list
			lstRetrievedStock = 
				stockService.retrieveStocks(StockHelper.getListStockCodesFromPendingStockOrders(lstPendingStockOrders));

			for (StockOrder thisStockOrder : lstPendingStockOrders) {
				if (processStockOrderLivePrice(thisStockOrder)) {
					counter++;
				}
			}
		}
		return counter;
	}

	/**
	 * @see com.doublelife.doublelife.services.StockProcessingService#processAtmarketPriceStockOrder(com.doublelife.doublelife.data.asset.stocks.StockOrder)
	 */
	public boolean processAtMarketPriceStockOrder(StockOrder stockOrder) {
		if (stockOrder.getIsBuyOrder() == StockOrder.BUY_ORDER) {
			if (userStockService.buyUserStock(stockOrder) && settleStockOrder(stockOrder)) {
				return true;
			} else {
				logger.error("Couldn't process BUY atMarket stock order: " + stockOrder.getId());
				return false; //TODO: handle errors!
			}
		} else {
			if (userStockService.sellUserStock(stockOrder) && settleStockOrder(stockOrder)) {
				return true;
			} else {
				logger.error("Couldn't process SELL atMarket stock order: " + stockOrder.getId());

				return false; //TODO: handle errors!
			}
		}
	}
	
	/**
	 * Processes the given stock-order to see whether it can be executed.
	 * If so, execute the order and return true.
	 * @param thisStockOrder
	 */
	private boolean processStockOrderLivePrice(StockOrder thisStockOrder) {
		RetrievedStock currentStock = 
			StockHelper.getRetrievedStockByCode(lstRetrievedStock, thisStockOrder.getStockCode());
		if (thisStockOrder.getIsBuyOrder() == StockOrder.BUY_ORDER) {
			//buy low
			if (thisStockOrder.getOrderPrice() >= currentStock.getCurrentPrice()) {
				if (userStockService.buyUserStock(thisStockOrder) && settleStockOrder(thisStockOrder)) {
					return true;
				} else {
					logger.error("Couldn't process BUY stock order: " + thisStockOrder.getId());
					return false; //TODO: handle errors!
				}
			}
		} else {
			//sell high
			if (thisStockOrder.getOrderPrice() <= currentStock.getCurrentPrice()) {
				if (userStockService.sellUserStock(thisStockOrder) && settleStockOrder(thisStockOrder)) {
					return true;
				} else {
					logger.error("Couldn't process SELL stock order: " + thisStockOrder.getId());
					return false; //TODO: handle errors!
				}
			}
		}
		return false;
	}
	
	private boolean settleStockOrder(StockOrder stockOrder) {
		stockOrder.setCompleted(StockOrder.COMPLETED_ORDER);
		stockOrder.setProcessedDateTime(new Date());
		boolean result = stockOrderDAO.saveStockOrder(stockOrder);
		if (result == false) {
			logger.error("Couldn't settle stock order: " + stockOrder.getId());
		}
		return result;
	}

	/**
	 * @param userStockService the userStockService to set
	 */
	public void setUserStockService(UserStockService userStockService) {
		this.userStockService = userStockService;
	}

	/**
	 * @return the userStockService
	 */
	public UserStockService getUserStockService() {
		return userStockService;
	}

	/**
	 * @return the stockDAO
	 */
	public StockOrderDAO getStockDAO() {
		return stockOrderDAO;
	}

	/**
	 * @param stockDAO the stockDAO to set
	 */
	public void setStockDAO(StockOrderDAO stockDAO) {
		this.stockOrderDAO = stockDAO;
	}

	/**
	 * @return the stockService
	 */
	public StockService getStockService() {
		return stockService;
	}

	/**
	 * @param stockService the stockService to set
	 */
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

}
