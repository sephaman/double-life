package com.doublelife.doublelife.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.services.StockService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/stockSearch.htm")
public class StockSearchController {

	private static final Logger logger = LoggerFactory.getLogger(StockSearchController.class);

	@Autowired
	private StockService stockService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initStockSearchPage() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		logger.info("Welcome to stock search!");
		ModelMap map = new ModelMap();
		map.addAttribute("userName", userDetails.getUsername());
		return new ModelAndView("stockSearch.tvw", map);
	}
	
	/**
	 * Finds the stocks to be viewed.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleSubmit(@RequestParam("stockCode") String stockCode) {
		logger.info("Stock Search Submission");
		List<String> lstStockCodes = new ArrayList<String>();
		lstStockCodes.add(stockCode);
		List<RetrievedStock> lstRetrievedStock = stockService.retrieveStocks(lstStockCodes);
		ModelMap map = new ModelMap();
		if (lstRetrievedStock.size() > 0) {
			map.addAttribute("stock", lstRetrievedStock.get(0));
		} else {
			map.addAttribute("noResult", "No stock found");
		}
		return new ModelAndView("stockSearch.tvw", map);
	}

	/**
	 * @param stockService the stockService to set
	 */
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	/**
	 * @return the stockService
	 */
	public StockService getStockService() {
		return stockService;
	}

}

