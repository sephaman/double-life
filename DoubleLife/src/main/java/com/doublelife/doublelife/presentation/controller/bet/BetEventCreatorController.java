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
import com.doublelife.doublelife.data.BetComp.BetEventParticipantPrice;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
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
	 * @param betEvent 
	 * @param betEventName 
	 * @param submitter 
	 * @param selectedParticipant 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createBetEvent(@ModelAttribute("betEvent") BetEvent betEvent,
			@RequestParam("betEventName") String betEventName, 
			@RequestParam("submissionType") String submitter,
			@RequestParam("participantSelect") String selectedParticipant,
			@RequestParam("part_price") String part_price) {
		logger.info("create bet event betEvent Controller : POST");
		
		if (submitter.equalsIgnoreCase("add")) {
			return addParticipant(betEvent, selectedParticipant, part_price);
		} else if (submitter.equalsIgnoreCase("remove")) {
			return removeParticipant(betEvent, selectedParticipant);
		} else if (submitter.equalsIgnoreCase("submitBtn")) {
			betEvent.setBetEventName(betEventName);
			betEvent.setOutcomePending(Boolean.TRUE);
			betEvent.setDateTime(new Date());  //TODO: parse date
			
			if (userBettingService.createBetEvent(betEvent)) {
				userBettingService.createAllBetEventParticipantPrices(betEvent);
			}
		}
		
		return new ModelAndView("createBetEvent.tvw");
	}
	
	
	private ModelAndView addParticipant(BetEvent betEvent, String participantSelect, String part_price) {
		BetParticipant betParticipant = userBettingService.getParticipantById(Long.parseLong(participantSelect));
		betEvent.getLstBetParticipant().add(betParticipant);
		
		//create a betEvetParticipantPrice object and store in betEvent
		betEvent.getLstBetEventParticipantPrice().add(new BetEventParticipantPrice(betParticipant, Double.parseDouble(part_price)));
		
		ModelMap map = new ModelMap();
		map.addAttribute("lstParticipants", userBettingService.getAllBetParticipants());
		map.addAttribute("lstBetEventTypes", userBettingService.getAllBetEventTypes());
		map.addAttribute("betEvent", betEvent);
		map.addAttribute("selectedParticipants", betEvent.getLstBetEventParticipantPrice());
		return new ModelAndView("createBetEvent.tvw", map);
	}
	
	private ModelAndView removeParticipant(BetEvent betEvent, String participantSelect) {
		for (int i = 0; i < betEvent.getLstBetParticipant().size(); i++) {
			if (betEvent.getLstBetParticipant().get(i).getId() == Long.parseLong(participantSelect)) {
				betEvent.getLstBetParticipant().remove(i);
				break;
			}
		}
		//remove the betEventParticipantPrice
		for (int i = 0; i < betEvent.getLstBetEventParticipantPrice().size(); i++) {
			if (betEvent.getLstBetEventParticipantPrice().get(i).getBetParticipant().getName().equalsIgnoreCase(participantSelect)) {
				betEvent.getLstBetEventParticipantPrice().remove(i);
				break;
			}
		}
		
		ModelMap map = new ModelMap();
		map.addAttribute("lstParticipants", userBettingService.getAllBetParticipants());
		map.addAttribute("lstBetEventTypes", userBettingService.getAllBetEventTypes());
		map.addAttribute("betEvent", betEvent);
		map.addAttribute("selectedParticipants", betEvent.getLstBetParticipant());
		return new ModelAndView("createBetEvent.tvw", map);
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

