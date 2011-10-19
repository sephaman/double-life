package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserStockPortfolioController {

	private static final Logger logger = LoggerFactory.getLogger(UserStockPortfolioController.class);

	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/userStockPortfolio", method=RequestMethod.GET)
	public ModelAndView home() {
		logger.info("Welcome to user stock portfolio!");
		ModelMap map = new ModelMap();
		
		return new ModelAndView("userStockPortfolio.tvw", map);
	}
	
}

