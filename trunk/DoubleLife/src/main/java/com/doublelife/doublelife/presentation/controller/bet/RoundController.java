package com.doublelife.doublelife.presentation.controller.bet;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
import com.doublelife.doublelife.data.validator.RoundValidator;
import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles creating Rounds.
 */
@Controller
@RequestMapping("/createRound.htm")
@SessionAttributes("round")
public class RoundController {

	@Autowired
	private UserBettingService userBettingService;
	
	@Autowired
	private RoundValidator roundValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(RoundController.class);

	/**
	 * Returns the create round form page.
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showCreateRound() {
		logger.info("create Round Controller : GET");
		ModelMap map = new ModelMap();
		
		List<Season> lstSeasons = userBettingService.getAllSeasons();
		lstSeasons.add(new Season(-1L, "none"));
		
		map.addAttribute("lstSeasons", lstSeasons);
		map.addAttribute("round", new Round());
		
		return new ModelAndView("createRound.tvw", map);
	}
	
	/**
	 * Validates and creates round.
	 * @param season 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createRound(@ModelAttribute("round") Round round, BindingResult result) {
		logger.info("create round Controller : POST");
		
		roundValidator.validate(round, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("createRound.tvw");
		}
		userBettingService.createRound(round); 
		
		return showCreateRound();
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
	 * @return the roundValidator
	 */
	public RoundValidator getRoundValidator() {
		return roundValidator;
	}

	/**
	 * @param roundValidator the roundValidator to set
	 */
	public void setRoundValidator(RoundValidator roundValidator) {
		this.roundValidator = roundValidator;
	}
}

