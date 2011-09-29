package com.doublelife.doublelife.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.doublelife.doublelife.dao.Stock;



public class XMLProcessor {

	//convert an xml response to a list of stock 
	public List<Stock> processGetStock(Document document) {
		try{
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nl = (NodeList) xpath.evaluate("/query/results/quote/AskRealtime", document, XPathConstants.NODESET);
		
		List<Stock> lstStock = new ArrayList<Stock>();

		for(int i=0; i < nl.getLength(); i++) {
			Stock stock = new Stock();
		/*	pp.setId(nl.item(i).getAttributes().getNamedItem(Constants.PHOTO_ID).getNodeValue());
			pp.setFarmNum(nl.item(i).getAttributes().getNamedItem(Constants.FARM).getNodeValue());
			pp.setPhotoName(nl.item(i).getAttributes().getNamedItem(Constants.PHOTO_TITLE).getNodeValue());
			pp.setSecretId(nl.item(i).getAttributes().getNamedItem(Constants.PHOTO_SECRET).getNodeValue());
			pp.setServer(nl.item(i).getAttributes().getNamedItem(Constants.SERVER).getNodeValue());
			lstStock.add(pp);*/
		}
		return lstStock;
		
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
		
}
