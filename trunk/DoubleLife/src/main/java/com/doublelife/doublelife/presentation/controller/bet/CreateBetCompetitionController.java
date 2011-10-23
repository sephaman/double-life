package com.doublelife.doublelife.presentation.controller.bet;

import java.util.Date;

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

import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.data.validator.BetCompetitionValidator;
import com.doublelife.doublelife.services.UserBettingService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Handles requests for creating betting competitions.
 */
@Controller
@RequestMapping("/betCompsCreate.htm")
@SessionAttributes("betCompetition")
public class CreateBetCompetitionController {

	@Autowired
	private UserBettingService userBettingService;
	
	@Autowired
	private BetCompetitionValidator betCompetitionValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateBetCompetitionController.class);

	/**
	 * Show the Create bet competition view.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showBetCompetitions() {
		logger.info("Bet Comps Create Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("betCompetition", new BetCompetition());
		return new ModelAndView("betCompsCreate.tvw", map);
	}
	
	/**
	 * Validates the betting comp and creates it. Returns success view.
	 * @param betCompetition 
	 * @param result 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleSubmit(@ModelAttribute("betCompetition") BetCompetition betCompetition, BindingResult result) {
		logger.info("User Registration Submission");
		betCompetitionValidator.validate(betCompetition, result);
		if (betCompetition.getAcctStartAmnt() < 1.00) {
			result.reject("acctStartAmnt", "Enter amount > 1.00");
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("betCompsCreate.tvw");
		} else {
			betCompetition.setCompStartDate(new Date());
			betCompetition.setCreatedByUserId(SecurityUtil.getCurrentUserId());
			betCompetition.setIsActive(1);
			boolean createResult = userBettingService.createBetCompetition(betCompetition);  //TODO: handle failures
			
			return new ModelAndView("betCompsCreate.tvw");
		}
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
	 * @param betCompetitionValidator the betCompetitionValidator to set
	 */
	public void setBetCompetitionValidator(BetCompetitionValidator betCompetitionValidator) {
		this.betCompetitionValidator = betCompetitionValidator;
	}

	/**
	 * @return the betCompetitionValidator
	 */
	public BetCompetitionValidator getBetCompetitionValidator() {
		return betCompetitionValidator;
	}
}

