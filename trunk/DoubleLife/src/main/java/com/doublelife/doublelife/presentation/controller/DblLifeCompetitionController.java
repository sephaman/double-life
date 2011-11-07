package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.Competition;
import com.doublelife.doublelife.services.CompetitionService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Handles requests for viewing and joining competitions.
 */
@Controller
public class DblLifeCompetitionController {

	@Autowired
	private CompetitionService competitionService;
	
	private static final Logger logger = LoggerFactory.getLogger(DblLifeCompetitionController.class);

	/**
	 * Displays current list of available competitions.
	 * @return 
	 */
	@RequestMapping(value="/dlCompsView.htm", method=RequestMethod.GET)
	public ModelAndView showBetEvents() {
		logger.info("DoubleLife Comp Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("dlComps", competitionService.getAllCurrentCompetitions());
		return new ModelAndView("dlCompsView.tvw", map);
	}
	
	/**
	 * Allows user to join the competition.
	 * @param compId 
	 * @return 
	 */
	@RequestMapping(value="/dlCompsJoin.htm", method=RequestMethod.GET)
	public ModelAndView joinCompetition(@RequestParam("id") long compId) {
		logger.info("Comps Controller join: GET");
		Competition comp = competitionService.getCompetitionById(compId);
		comp.getLstUser().add(SecurityUtil.getCurrentUser());
		competitionService.createCompetition(comp);
		ModelMap map = new ModelMap();
		map.addAttribute("registered", true);
		map.addAttribute("joinedComp", comp);
		return new ModelAndView("dlCompsSuccessJoinView.tvw", map);
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

