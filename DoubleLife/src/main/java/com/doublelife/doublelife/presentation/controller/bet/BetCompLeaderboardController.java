package com.doublelife.doublelife.presentation.controller.bet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles requests for displaying betting competitions.
 */
@Controller
public class BetCompLeaderboardController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(BetCompLeaderboardController.class);

	/**
	 * Loads the leaderboard page.
	 * @param compId 
	 * @return 
	 */
	@RequestMapping(value="/betCompLeaderboardView.htm", method=RequestMethod.GET)
	public ModelAndView showBetCompLeaderboardView(@RequestParam("id") long compId) {
		logger.info("Bet Comp Leaderboard Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("leaderboard", userBettingService.getLeaderBoardForCompetition(compId));
		return new ModelAndView("betCompLeaderboardView.tvw", map);
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

