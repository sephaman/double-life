package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the fantasy betting home page.
 */
@Controller
public class FantasyBettingHomeController {

	private static final Logger logger = LoggerFactory.getLogger(FantasyBettingHomeController.class);

	/**
	 * Gets the main menu for fantasy betting.
	 * @return 
	 */
	@RequestMapping(value="/fantasyBetHome.htm", method=RequestMethod.GET)
	public ModelAndView fantasyBetHome() {
		logger.info("FantasyBet Home Controller : GET");
		ModelMap map = new ModelMap();
		
		return new ModelAndView("fantasyBetHome.tvw", map);
	}
	
}

