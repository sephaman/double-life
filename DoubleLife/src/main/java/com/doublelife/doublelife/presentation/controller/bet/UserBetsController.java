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
 * Handles requests for displaying user's bets.
 */
@Controller
public class UserBetsController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserBetsController.class);

	/**
	 * Returns a view displaying a user's bets and their selections.
	 * @return 
	 */
	@RequestMapping(value="/userBets.htm", method=RequestMethod.GET)
	public ModelAndView showUserBets() {
		logger.info("User Bets Contoller: GET");
		ModelMap map = new ModelMap();
		map.addAttribute("userBets",
				userBettingService.getMappedBetAndSelection());
		return new ModelAndView("userBets.tvw", map);
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

