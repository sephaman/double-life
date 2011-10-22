package com.doublelife.doublelife.presentation.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.UserStockHolding;
import com.doublelife.doublelife.services.StockProcessingService;

/**
 * Handles requests for the user stock portfolio page, containing portfolio and live prices
 * for user's stock.
 */
@Controller
public class UserStockPortfolioController {

	private static final Logger logger = LoggerFactory.getLogger(UserStockPortfolioController.class);

	@Autowired
	private StockProcessingService stockProcessingService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/userStockPortfolio", method=RequestMethod.GET)
	public ModelAndView getUserPortFolioPage() {
		logger.info("Welcome to user stock portfolio!");
		long userId = 22;  //TODO: get user id from security
		ModelMap map = new ModelMap();
		Map<UserStockHolding, RetrievedStock> stockMap = stockProcessingService.getUserLiveStockMappings(userId);
		map.addAttribute("stockMap", stockMap);
		return new ModelAndView("userStockPortfolio.tvw", map);
	}

	/**
	 * @param stockProcessingService the stockProcessingService to set
	 */
	public void setStockProcessingService(StockProcessingService stockProcessingService) {
		this.stockProcessingService = stockProcessingService;
	}

	/**
	 * @return the stockProcessingService
	 */
	public StockProcessingService getStockProcessingService() {
		return stockProcessingService;
	}
	
}

