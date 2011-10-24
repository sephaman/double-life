package com.doublelife.doublelife.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.asset.stocks.RetrievedStock;
import com.doublelife.doublelife.data.asset.stocks.StockOrder;
import com.doublelife.doublelife.data.validator.StockOrderValidator;
import com.doublelife.doublelife.services.StockService;
import com.doublelife.doublelife.services.UserStockService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/orderStock.htm")
@SessionAttributes("stockOrder")
public class StockOrderController {

	private static final Logger logger = LoggerFactory.getLogger(StockOrderController.class);

	@Autowired
	private UserStockService userStockService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private StockOrderValidator stockOrderValidator;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @param stockCode 
	 * @param buySell 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initStockOrderPage(@RequestParam("stockCode")String stockCode,
			@RequestParam("action")String buySell) {
		logger.info("Stock order vontroller GET");
		List<String> lstStockCodes = new ArrayList<String>();
		lstStockCodes.add(stockCode);
		List<RetrievedStock> lstRetrievedStock = stockService.retrieveStocks(lstStockCodes);
		ModelMap map = new ModelMap();
		if (lstRetrievedStock.size() > 0) {
			map.addAttribute("stock", lstRetrievedStock.get(0));
		}
		StockOrder stockOrder = new StockOrder();
		stockOrder.setIsBuyOrder(1);
		map.addAttribute("stockOrder", stockOrder);
		return new ModelAndView("stockOrder.tvw", map);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleSubmit(@ModelAttribute("stockOrder") StockOrder stockOrder, BindingResult result) {
		logger.info("User Registration Submission");
		stockOrderValidator.validate(stockOrder, result);
			return new ModelAndView("stockOrderConfirmation.tvw");
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
	 * @return the stockOrderValidator
	 */
	public StockOrderValidator getStockOrderValidator() {
		return stockOrderValidator;
	}

	/**
	 * @param stockOrderValidator the stockOrderValidator to set
	 */
	public void setStockOrderValidator(StockOrderValidator stockOrderValidator) {
		this.stockOrderValidator = stockOrderValidator;
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

