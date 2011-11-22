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

import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BetEventsController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(BetEventsController.class);

	/**
	 * Called to display a list of bet events.
	 */
	@RequestMapping(value="/betEventsView.htm", method=RequestMethod.GET)
	public ModelAndView showBetEvents() {
		logger.info("betEvents Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("betEvents", userBettingService.getAllCurrentBetEvents());
		return new ModelAndView("betEventsView.tvw", map);
	}
	
	/**
	 * Called to display a single of bet event that can be betted on by the user.
	 * @param betEventId 
	 * @return 
	 */
	@RequestMapping(value="/betViewer.htm", method=RequestMethod.GET)
	public ModelAndView showSingleBetEvent(@RequestParam("id") long betEventId) {
		logger.info("single betEvent Controller : GET");
		ModelMap map = new ModelMap();
		BetEvent betEvent = userBettingService.getBetEventById(betEventId);
		map.addAttribute("betEvent", betEvent);
		map.addAttribute("betParticipants", userBettingService.getMappedParticipantAndPrice(betEvent));
		return new ModelAndView("betViewer.tvw", map);
	}
	
	/**
	 * Called to handle bet submission.
	 * @param stake 
	 * @param selection 
	 * @param betEventId 
	 * @return 
	 */
	@RequestMapping(value="/betViewer.htm", method=RequestMethod.POST)
	public ModelAndView handleSingleBetEvent(@RequestParam("stake") double stake, 
			@RequestParam("betSelect") String selection, @RequestParam("betEventId") long betEventId) {
		logger.info("single betEvent Controller : POST");
		//TODO: check inputs
		String[] strParts = selection.split(":");
		long participantId = Long.parseLong(strParts[0]);
		double odds = Double.parseDouble(strParts[1]);
		userBettingService.createAndSaveBet(betEventId, participantId, stake, odds);
		return showBetEvents();
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

