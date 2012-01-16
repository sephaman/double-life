package com.doublelife.doublelife.presentation.controller.bet;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles creating Bet Events.
 */
@Controller
@RequestMapping("/createBetEvent.htm")
@SessionAttributes("betEvent")
public class BetEventCreatorController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(BetEventCreatorController.class);

	/**
	 * Returns the create bet event form page.
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showCreateBetEvent() {
		logger.info("create bet event betEvent Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("lstParticipants", userBettingService.getAllBetParticipants());
		map.addAttribute("lstBetEventTypes", userBettingService.getAllBetEventTypes());
		map.addAttribute("betEvent", new BetEvent());
		return new ModelAndView("createBetEvent.tvw", map);
	}
	
	/**
	 * Validates and creates bet event.
	 * @param betEventName 
	 * @param betEventDate 
	 * @param betEventParticipants 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createBetEvent(@ModelAttribute("betEvent") BetEvent betEvent, @RequestParam("betEventName") String betEventName, 
			//@RequestParam("betEventDate") String betEventDate, 
			//@RequestParam("betEventParticipants") String betEventParticipants,
			@RequestParam("submissionType") String submitter) {
		logger.info("create bet event betEvent Controller : POST");
		
		betEvent.setBetEventName(betEventName);
		betEvent.setOutcomePending(Boolean.TRUE);
		betEvent.setDateTime(new Date());  //TODO: parse date
		userBettingService.createBetEvent(betEvent);
		return new ModelAndView("createBetEvent.tvw");
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

