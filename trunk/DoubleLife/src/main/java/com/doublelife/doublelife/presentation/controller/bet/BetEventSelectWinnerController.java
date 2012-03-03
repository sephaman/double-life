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
@RequestMapping("/betEventWinSelect.htm")
@SessionAttributes("betEvent")
public class BetEventSelectWinnerController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(BetEventSelectWinnerController.class);

	/**
	 * Returns the bet event winner select form page.
	 * @param betEventId 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showSelectWinnerBetEvent(@RequestParam("id") long betEventId) {
		logger.info("update bet event betEvent Controller : GET");
		ModelMap map = new ModelMap();
		BetEvent betEvent = userBettingService.getBetEventById(betEventId);
		map.addAttribute("betEvent", betEvent);
		map.addAttribute("lstParticipant", betEvent.getLstBetParticipant());
		return new ModelAndView("selectWinnerBetEvent.tvw", map);
	}
	
	/**
	 * Validates and updates bet event.
	 * @param betEvent 
	 * @param winner 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView updateBetEvent(@ModelAttribute("betEvent") BetEvent betEvent,
			@RequestParam("winner") long winner)
	{
		logger.info("update bet event betEvent Controller : POST");
		betEvent.setSelectionWinnerId(winner);
		userBettingService.updateBetEvent(betEvent);
		
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

