package com.doublelife.doublelife.presentation.controller.bet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
import com.doublelife.doublelife.presentation.viewhelper.BetEventViewHelper;
import com.doublelife.doublelife.services.UserBettingService;

/**
 * Handles requests for displaying seasons and associated rounds.
 */
@Controller
public class ViewSeasonRoundController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(ViewSeasonRoundController.class);

	/**
	 * Returns a view displaying a list of seasons.
	 * @return 
	 */
	@RequestMapping(value="/viewSeasons.htm", method=RequestMethod.GET)
	public ModelAndView showAllSeasons() {
		logger.info("ViewSeasonRoundController - show seasons: GET");
		ModelMap map = new ModelMap();
		
		map.addAttribute("lstSeasons", userBettingService.getAllSeasons());
		
		return new ModelAndView("viewAllSeasons.tvw", map);
	}
	
	/**
	 * Returns a view displaying  the season and its associated rounds.
	 * @param seasonId 
	 * @return 
	 */
	@RequestMapping(value="/seasonViewer.htm", method=RequestMethod.GET)
	public ModelAndView showSingleSeason(@RequestParam("id") long seasonId) {
		logger.info("ViewSeasonRoundController - show single season: GET");
		ModelMap map = new ModelMap();
		
		Season thisSeason = userBettingService.getSeasonById(seasonId);
		
		map.addAttribute("thisSeason", thisSeason);
		
		map.addAttribute("roundsmap", createMapOfRounds(userBettingService.getRoundsBySeasonId(seasonId)));
		
		return new ModelAndView("viewSeason.tvw", map);
	}
	
	/**
	 * Returns a view displaying the round and its associated bet events.
	 * @param roundId 
	 * @return 
	 */
	@RequestMapping(value="/roundViewer.htm", method=RequestMethod.GET)
	public ModelAndView showRound(@RequestParam("id") long roundId) {
		logger.info("ViewSeasonRoundController - show round: GET");
		ModelMap map = new ModelMap();
		
		Round thisRound = userBettingService.getRoundById(roundId);
		
		map.addAttribute("thisRound", thisRound);
		List<BetEvent> lstEvents = userBettingService.getBetEventsByRoundId(roundId);
		
		List<BetEventViewHelper> lstBetEvents = new ArrayList<BetEventViewHelper>();
		
		for (BetEvent thisEvent : lstEvents) {
			lstBetEvents.add(constructBetEventViewHelper(thisEvent));
		}
		
		map.addAttribute("betEvents", lstBetEvents);
		
		return new ModelAndView("viewRound.tvw", map);
	}
	
	/**
	 * @return
	 */
	private BetEventViewHelper constructBetEventViewHelper(BetEvent betEvent) {
		BetEventViewHelper viewHelper = new BetEventViewHelper();
		Map<BetParticipant, Double> thisMap = userBettingService.getMappedParticipantAndPrice(betEvent);
		
		viewHelper.setBetEventId(betEvent.getId());
		viewHelper.setHomeOdds(thisMap.get(betEvent.getLstBetParticipant().get(0)));
		viewHelper.setAwayOdds(thisMap.get(betEvent.getLstBetParticipant().get(1)));
		viewHelper.setHomeParticipantId(betEvent.getLstBetParticipant().get(0).getId());
		viewHelper.setAwayParticipantId(betEvent.getLstBetParticipant().get(1).getId());
		viewHelper.setParticipantHomeName(betEvent.getLstBetParticipant().get(0).getName());
		viewHelper.setParticipantAwayName(betEvent.getLstBetParticipant().get(1).getName());
		viewHelper.setBetEventName(betEvent.getBetEventName());
		
		return viewHelper;
	}

	private Map<Integer, List<Round>> createMapOfRounds(List<Round> lstRounds) {
		Map<Integer, List<Round>> retVal = new HashMap<Integer, List<Round>>();
		
		for (int i = 0; i <= lstRounds.size() / 3; i++) {
			List<Round> subListRounds = new ArrayList<Round>();
			for (int x = i * 3; x < (i * 3) + 3; x++) {
				subListRounds.add(lstRounds.get(x));
			}
			retVal.put(i, subListRounds);
		}
		
		return retVal;
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

