package com.doublelife.doublelife.presentation.controller.bet;

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
 * Handles requests for displaying all user bets.
 */
@Controller
public class ViewAllBetsController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(ViewAllBetsController.class);

	/**
	 * Returns a view displaying an empty bet viewing page.
	 * @return 
	 */
	@RequestMapping(value="/viewAllBets.htm", method=RequestMethod.GET)
	public ModelAndView showUserBets() {
		logger.info("All User Bets Contoller: GET");
		ModelMap map = new ModelMap();
		return new ModelAndView("viewAllBets.tvw", map);
	}
	
	/**
	 * @param userBettingService the userBettingService to set
	 */
	public void setUserBettingService(UserBettingService userBettingService) {
		this.userBettingService = userBettingService;
	}

	/**
	 * @return the userBettingService
	 */
	public UserBettingService getUserBettingService() {
		return userBettingService;
	}
}

