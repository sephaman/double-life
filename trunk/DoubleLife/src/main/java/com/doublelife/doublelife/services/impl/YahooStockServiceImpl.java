package com.doublelife.doublelife.services.impl;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.doublelife.doublelife.dao.Stock;
import com.doublelife.doublelife.services.StockService;


/**
 * A Stock Service implementation making use of RESTful Yahoo services. 
 * @author Joseph McAleer
 */
public class YahooStockServiceImpl implements StockService {

	private String stockQuoteRestStr = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22CSS.AX%22)%0A%09%09&env=http%3A%2F%2Fdatatables.org%2Falltables.env";
	
	public double getPrice(String stockCode) {
		try{
			URL callUrl = new URL(stockQuoteRestStr);
			HttpURLConnection urlConnection = (HttpURLConnection)callUrl.openConnection();
			InputStream urlStream = urlConnection.getInputStream();
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(urlStream);
			
			XMLProcessor xmlP = new XMLProcessor();
			
			List<Stock> lstStock = new ArrayList<Stock>();
			lstStock = xmlP.processGetStock(document);

			urlConnection.disconnect();
			
			return 0;
			} catch(Exception ex) {
				System.out.println("Exception:" + ex.getMessage());
				return -1;
			}
	}
	
	  
}
