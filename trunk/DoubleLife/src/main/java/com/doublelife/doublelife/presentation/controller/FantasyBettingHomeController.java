package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles requests for the fantasy betting home page.
 */
@Controller
public class FantasyBettingHomeController {

	private static final Logger logger = LoggerFactory.getLogger(FantasyBettingHomeController.class);

	@Autowired
	private UserBettingService userBettingService;
	
	/**
	 * Gets the main menu for fantasy betting.
	 * @return 
	 */
	@RequestMapping(value="/fantasyBetHome.htm", method=RequestMethod.GET)
	public ModelAndView fantasyBetHome() {
		logger.info("FantasyBet Home Controller : GET");
		ModelMap map = new ModelMap();
		
		//grab the active round and stick it in the model
		map.addAttribute("currentRound", userBettingService.getActiveRoundForComp(1)); //TODO: need to retrieve season id
		return new ModelAndView("fantasyBetHome.tvw", map);
	}

	/**
	 * @return the userBettingService
	 */
	public UserBettingService getUserBettingService() {
		return userBettingService;
	}

	/**
	 * @param userBettingService the userBettingService to set
	 */
	public void setUserBettingService(UserBettingService userBettingService) {
		this.userBettingService = userBettingService;
	}
	
}

