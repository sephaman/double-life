package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;



public class YahooXMLProcessor {

	//convert an xml response to a list of stock 
	public List<RetrievedStock> processGetStock(Document document) {
		try{
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nl = (NodeList) xpath.evaluate("/query/results/quote", document, XPathConstants.NODESET);
		
		List<RetrievedStock> lstStock = new ArrayList<RetrievedStock>();

		for(int i=0; i < nl.getLength(); i++) {
			
			RetrievedStock stock = new RetrievedStock();
			stock.setCurrentPrice(Double.parseDouble(getNodeValueFromElement((Element) nl.item(i), "AskRealtime")));
			stock.setStockCode(getNodeValueFromElement((Element) nl.item(i), "Symbol"));
			stock.setStockName(getNodeValueFromElement((Element) nl.item(i), "Name"));
			lstStock.add(stock);
		}
		return lstStock;
		
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return new ArrayList<RetrievedStock>();
		}
	}
	
	private String getNodeValueFromElement(Element element, String nodeName) {
		NodeList nl = element.getElementsByTagName(nodeName);
		
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			if (node.getNodeName().equals(nodeName)) {
				return node.getNodeValue();
			}
		}
		
		return null;
	}
}
