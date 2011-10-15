/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.dao.StockDAO;
import com.doublelife.doublelife.services.StockProcessingService;
import com.doublelife.doublelife.services.StockService;
import com.doublelife.doublelife.services.UserStockService;
import com.doublelife.doublelife.services.utils.StockHelper;

/**
 * @author Joseph McAleer
 *
 */
public class StockProcessingServiceImpl implements StockProcessingService {

	private UserStockService userStockService;
	private StockDAO stockDAO;
	private StockService stockService;
	
	//internal list to be refreshed. Shouldn't be accessible outside class.
	private List<RetrievedStock> lstRetrievedStock = new ArrayList<RetrievedStock>();
	
	/**
	 * @see com.doublelife.doublelife.services.StockProcessingService#checkAndProcessPendingStocks()
	 */
	public int checkAndProcessPendingStocksLivePrices() {
		int counter = 0;
		List<StockOrder> lstPendingStockOrders = stockDAO.getAllPendingStockOrders();
		
		if (lstPendingStockOrders != null && lstPendingStockOrders.size() > 0) {
			//refresh retrieved stock list
			lstRetrievedStock = 
				stockService.retrieveStocks(StockHelper.getListStockCodesFromPendingStockOrders(lstPendingStockOrders));

			for (StockOrder thisStockOrder : lstPendingStockOrders) {
				processStockOrderLivePrice(thisStockOrder);
			}
		}
		return counter;
	}

	public void processAtmarketPriceStockOrder(StockOrder stockOrder) {
		
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
				if (userStockService.buyUserStock(thisStockOrder)) {
					return true;
				} else {
					return false; //TODO: handle errors!
				}
			}
		} else {
			//sell high
			if (thisStockOrder.getOrderPrice() <= currentStock.getCurrentPrice()) {
				if (userStockService.sellUserStock(thisStockOrder)) {
					return true;
				} else {
					return false; //TODO: handle errors!
				}
			}
		}
		return false;
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
	public StockDAO getStockDAO() {
		return stockDAO;
	}

	/**
	 * @param stockDAO the stockDAO to set
	 */
	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
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
