package com.doublelife.doublelife.presentation.controller.bet;

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
@RequestMapping("/betEventUpdate.htm")
@SessionAttributes("betEvent")
public class BetEventUpdaterController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(BetEventUpdaterController.class);

	/**
	 * Returns the update bet event form page.
	 * @param betEventId 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showUpdateBetEvent(@RequestParam("id") long betEventId) {
		logger.info("update bet event betEvent Controller : GET");
		ModelMap map = new ModelMap();
		BetEvent betEvent = userBettingService.getBetEventById(betEventId);
		map.addAttribute("betEvent", betEvent);
		map.addAttribute("betEventType", userBettingService.getBetEventTypeById(betEvent.getBetEventTypeId()));
		map.addAttribute("lstParticipant", userBettingService.getMappedParticipantAndPrice(betEvent));
		return new ModelAndView("updateBetEvent.tvw", map);
	}
	
	/**
	 * Validates and updates bet event.
	 * @param betEvent 
	 * @param betEventName 
	 * @param submitter 
	 * @param selectedParticipant 
	 * @param part_price 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createBetEvent(@ModelAttribute("betEvent") BetEvent betEvent,
			@RequestParam("part_price") String betPrices,
			@RequestParam("id_price") String idPrices
			)
			 {
		logger.info("update bet event betEvent Controller : POST");
		
		boolean result = userBettingService.updateSubmittedBetPrices(idPrices, betPrices, betEvent);
		
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

