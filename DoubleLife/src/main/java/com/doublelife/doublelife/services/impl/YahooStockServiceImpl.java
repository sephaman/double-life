package com.doublelife.doublelife.services.impl;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.asset.stocks.StockPortfolio;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;
import com.doublelife.doublelife.data.dao.UserStockDAO;
import com.doublelife.doublelife.services.StockService;
import com.doublelife.doublelife.services.utils.HttpHelper;

	/**
	 * Stock Service implemented using the Yahoo YQL service.
	 * @author Joseph McAleer
	 */
	public class YahooStockServiceImpl implements StockService {	
	
		private UserStockDAO userStockDAO;
		
		String requestString = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(STOCKCODES)%0A%09%09&env=http%3A%2F%2Fdatatables.org%2Falltables.env";
	
		public List<RetrievedStock> retrieveStocks(List<String> lstStockCodes) {
			try{
				String constructedRequest = constructRequestString(lstStockCodes);
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = builder.parse(new InputSource(new StringReader(HttpHelper.getHttpRequestBody(constructedRequest))));
				
				XMLProcessor xmlP = new XMLProcessor();
				
				List<RetrievedStock> lstStock = xmlP.processGetStock(document);

				return lstStock;
				} catch(Exception ex) {
					System.out.println("Exception:" + ex.getMessage());
					return null;
				}
	}
		
		private String constructRequestString(String stockCode) {
			List<String> lstStockCodes = new ArrayList<String>();
			lstStockCodes.add(stockCode);
			return constructRequestString(lstStockCodes);
		}
		
		private String constructRequestString(List<String> lstStockCodes) {
			String stockCodes = "";
			for (int i = 0; i < lstStockCodes.size(); i++) {
				stockCodes = stockCodes + "%22" + lstStockCodes.get(i) + "%22";
				if (i != (lstStockCodes.size() - 1)) {
					stockCodes = stockCodes + "%2C";
				}
			}
			
			return requestString.replace("STOCKCODES", stockCodes);
		}

		/**
		 * @see com.doublelife.doublelife.services.StockService#getStockMappings(com.doublelife.doublelife.UserStockHolding)
		 */
		public Map<UserStockHolding, RetrievedStock> getStockMappings(
				StockPortfolio stockPortfolio) {
			Map<UserStockHolding, RetrievedStock> mappedStocks = new HashMap<UserStockHolding, RetrievedStock>();
			
			//only want to make one external request - grab dtaa once and map it!
			List<RetrievedStock> lstRetrievedStocks = retrieveStocks(stockPortfolio.getPortfolioStockCodes());
			Map<String, UserStockHolding> mappedUserHoldings = stockPortfolio.getHoldingsMappedToStockCode(); 
			for (RetrievedStock thisRetrievedStock : lstRetrievedStocks) {
				mappedStocks.put(mappedUserHoldings.get(thisRetrievedStock.getStockCode()), thisRetrievedStock);
			}
			return mappedStocks;
		}

		/* (non-Javadoc)
		 * @see com.doublelife.doublelife.services.StockService#buyUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)
		 */
		@Override
		public void buyUserStock(StockOrder stockOrder) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.doublelife.doublelife.services.StockService#sellUserStock(com.doublelife.doublelife.data.asset.stocks.StockOrder)
		 */
		@Override
		public void sellUserStock(StockOrder stockOrder) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * @param userStockDAO the userStockDAO to set
		 */
		public void setUserStockDAO(UserStockDAO userStockDAO) {
			this.userStockDAO = userStockDAO;
		}

		/**
		 * @return the userStockDAO
		 */
		public UserStockDAO getUserStockDAO() {
			return userStockDAO;
		}
}
