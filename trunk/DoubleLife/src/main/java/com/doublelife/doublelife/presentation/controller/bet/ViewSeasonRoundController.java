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

import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles requests for displaying seasons and associated rounds.
 */
@Controller
public class ViewSeasonRoundController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(ViewSeasonRoundController.class);

	/**
	 * Returns a view displaying a list of seasons.
	 * @return 
	 */
	@RequestMapping(value="/viewSeasons.htm", method=RequestMethod.GET)
	public ModelAndView showAllSeasons() {
		logger.info("ViewSeasonRoundController - show seasons: GET");
		ModelMap map = new ModelMap();
		
		map.addAttribute("lstSeasons", userBettingService.getAllSeasons());
		
		return new ModelAndView("viewAllSeasons.tvw", map);
	}
	
	/**
	 * Returns a view displaying  the season and its associated rounds.
	 * @param seasonId 
	 * @return 
	 */
	@RequestMapping(value="/seasonViewer.htm", method=RequestMethod.GET)
	public ModelAndView showSingleSeason(@RequestParam("id") long seasonId) {
		logger.info("ViewSeasonRoundController - show single season: GET");
		ModelMap map = new ModelMap();
		
		Season thisSeason = userBettingService.getSeasonById(seasonId);
		
		map.addAttribute("thisSeason", thisSeason);
		map.addAttribute("rounds", userBettingService.getRoundsBySeasonId(seasonId));
		
		return new ModelAndView("viewSeason.tvw", map);
	}
	
	/**
	 * Returns a view displaying the season and its associated rounds.
	 * @param seasonId 
	 * @return 
	 */
	@RequestMapping(value="/roundViewer.htm", method=RequestMethod.GET)
	public ModelAndView showRound(@RequestParam("id") long roundId) {
		logger.info("ViewSeasonRoundController - show round: GET");
		ModelMap map = new ModelMap();
		
		Round thisRound = userBettingService.getRoundById(roundId);
		
		map.addAttribute("thisRound", thisRound);
		map.addAttribute("betEvents", userBettingService.getBetEventsByRoundId(roundId));
		
		return new ModelAndView("viewRound.tvw", map);
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

