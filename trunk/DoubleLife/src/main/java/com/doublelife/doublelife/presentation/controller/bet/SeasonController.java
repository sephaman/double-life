package com.doublelife.doublelife.presentation.controller.bet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.BetComp.Season;
import com.doublelife.doublelife.data.validator.SeasonValidator;
import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles creating Season.
 */
@Controller
@RequestMapping("/createSeason.htm")
@SessionAttributes("season")
public class SeasonController {

	@Autowired
	private UserBettingService userBettingService;
	
	@Autowired
	private SeasonValidator seasonValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonController.class);

	/**
	 * Returns the create season form page.
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showCreateSeason() {
		logger.info("create Season Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("lstBetEventTypes", userBettingService.getAllBetEventTypes());
		map.addAttribute("season", new Season());
		return new ModelAndView("createSeason.tvw", map);
	}
	
	/**
	 * Validates and creates season.
	 * @param season 
	 * @param result 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createSeason(@ModelAttribute("season") Season season, BindingResult result) {
		logger.info("create season Controller : POST");
		seasonValidator.validate(season, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("dlCompsCreate.tvw");
		}
		userBettingService.createSeason(season); 
		
		return showCreateSeason();
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

	/**
	 * @return the seasonValidator
	 */
	public SeasonValidator getSeasonValidator() {
		return seasonValidator;
	}

	/**
	 * @param seasonValidator the seasonValidator to set
	 */
	public void setSeasonValidator(SeasonValidator seasonValidator) {
		this.seasonValidator = seasonValidator;
	}
}

