package com.doublelife.doublelife.presentation.controller;

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

import com.doublelife.doublelife.data.Competition;
import com.doublelife.doublelife.data.validator.CompetitionValidator;
import com.doublelife.doublelife.services.CompetitionService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Handles requests for creating betting competitions.
 */
@Controller
@RequestMapping("/dlCompsCreate.htm")
@SessionAttributes("competition")
public class CreateCompetitionController {

	@Autowired
	private CompetitionService competitionService;
	
	@Autowired
	private CompetitionValidator competitionValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateCompetitionController.class);

	/**
	 * Show the Create bet competition view.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showCompetitions() {
		logger.info("Bet Comps Create Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("competition", new Competition());
		return new ModelAndView("dlCompsCreate.tvw", map);
	}
	
	/**
	 * Validates the betting comp and creates it. Returns success view.
	 * @param betCompetition 
	 * @param result 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleSubmit(@ModelAttribute("competition") Competition competition, BindingResult result) {
		logger.info("Competition Submission");
		competitionValidator.validate(competition, result);
		if (competition.getAcctStartAmnt() < 1.00) {
			result.reject("acctStartAmnt", "Enter amount > 1.00");
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("dlCompsCreate.tvw");
		} else {
			competition.setCompStartDate(new Date());
			competition.setCreatedByUserId(SecurityUtil.getCurrentUserId());
			competition.setIsActive(1);
			boolean createResult = competitionService.createCompetition(competition);  //TODO: handle failures
			
			return new ModelAndView("dlCompsCreate.tvw");
		}
	}

	/**
	 * @param competitionValidator the competitionValidator to set
	 */
	public void setCompetitionValidator(CompetitionValidator competitionValidator) {
		this.competitionValidator = competitionValidator;
	}

	/**
	 * @return the competitionValidator
	 */
	public CompetitionValidator getCompetitionValidator() {
		return competitionValidator;
	}

	/**
	 * @param competitionService the competitionService to set
	 */
	public void setCompetitionService(CompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	/**
	 * @return the competitionService
	 */
	public CompetitionService getCompetitionService() {
		return competitionService;
	}
}

