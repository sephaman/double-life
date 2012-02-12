package com.doublelife.doublelife.presentation.controller.bet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetCompRules;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.BetTip;
import com.doublelife.doublelife.data.BetComp.Round;
import com.doublelife.doublelife.data.BetComp.Season;
import com.doublelife.doublelife.presentation.viewhelper.BetEventViewHelper;
import com.doublelife.doublelife.services.UserBettingService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Handles requests for displaying seasons and associated rounds.
 */
@Controller
public class ViewSeasonRoundController {

	@Autowired
	private UserBettingService userBettingService;
	
	private final String compRulesIdParam = "compRulesId";
	private final String homeWagerParam = "homeWager-";
	private final String awayWagerParam = "awayWager-";
	private final String tipParam = "tip-";
	private final String homeOddsParam = "homeOdds-";
	private final String awayOddsParam = "awayOdds-";
	
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
	public ModelAndView showRound(@RequestParam("id") long roundId, @RequestParam("compId") long compId) {
		logger.info("ViewSeasonRoundController - show round: GET");
		ModelMap map = new ModelMap();
		
		Round thisRound = userBettingService.getRoundById(roundId);
	
		List<BetEvent> lstEvents = userBettingService.getBetEventsByRoundId(roundId);
		List<Long> lstBetEventIds = getIdsFromEvents(lstEvents);
		
		//get any existing bets and bet tips
		List<Bet> lstExistingBets = userBettingService.getUserBetsByRoundAndComp(lstBetEventIds, compId, SecurityUtil.getCurrentUserId());
		List<BetTip> lstExistingBetTips = userBettingService.getUserBetTipsByRoundAndComp(roundId, compId, SecurityUtil.getCurrentUserId());
		
		List<BetEventViewHelper> lstBetEvents = new ArrayList<BetEventViewHelper>();
		
		for (BetEvent thisEvent : lstEvents) {
			BetTip betTip = getBetTipFromList(thisEvent, lstExistingBetTips);
			Bet bet = getBetFromList(thisEvent, lstExistingBets);
			lstBetEvents.add(constructBetEventViewHelper(thisEvent, betTip, bet));
		}
		
		map.addAttribute("thisRound", thisRound);
		map.addAttribute("nextRound", userBettingService.getNextRoundBySequence(thisRound));
		map.addAttribute("prevRound", userBettingService.getPrevRoundBySequence(thisRound));
		
		map.addAttribute("betEvents", lstBetEvents);
		//TODO: apply comp rules
		if (lstExistingBets.size() > 0 || lstExistingBetTips.size() > 0) {
			map.addAttribute("betSubmitted", true);
		} else {
			map.addAttribute("betSubmitted", false);
		}
		
		return new ModelAndView("viewRound.tvw", map);
	}
	
	/**
	 * Returns a view displaying the round and its associated bet events.
	 * @param roundId 
	 * @return 
	 */
	@RequestMapping(value="/roundViewer.htm", method=RequestMethod.POST)
	public ModelAndView roundSubmission() {
		logger.info("ViewSeasonRoundController - show round: POST");
		ModelMap map = new ModelMap();
		HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
				
		long roundId = Long.parseLong(curRequest.getParameter("roundId"));
		Round thisRound = userBettingService.getRoundById(roundId);
		
		map.addAttribute("thisRound", thisRound);
		List<BetEvent> lstEvents = userBettingService.getBetEventsByRoundId(roundId);
		
		map.addAttribute("betEvents", lstEvents);
		
		processSubmissionRequest(curRequest, lstEvents);
		long compRulesId = Long.parseLong(curRequest.getParameter(compRulesIdParam));
		BetCompRules betCompRules = userBettingService.getBetCompRulesByCompId(compRulesId);
		
		return showRound(roundId, betCompRules.getCompId());
	}
	
	private boolean processSubmissionRequest(HttpServletRequest request, List<BetEvent> lstBetEvents) {
		
		long compRulesId = Long.parseLong(request.getParameter(compRulesIdParam));
		BetCompRules betCompRules = userBettingService.getBetCompRulesByCompId(compRulesId);
		
		for (BetEvent thisEvent : lstBetEvents) {
			//generate tips
			if (betCompRules.getCanTip()) {
				processBetTips(request, thisEvent, betCompRules);
			}
			//generate bets
			if (betCompRules.getCanBet()) {
				processBetEvents(request, thisEvent, betCompRules);
			}
		}
		return true;
	}

	/**
	 * Processes Bet Events submitted.
	 * @param request
	 * @param lstBetEvents
	 * @param betCompRules
	 */
	private boolean processBetEvents(HttpServletRequest request,
			BetEvent thisEvent, BetCompRules betCompRules) {
		Double homeWager = Double.parseDouble(request.getParameter(homeWagerParam + thisEvent.getId()));
		Double awayWager = Double.parseDouble(request.getParameter(awayWagerParam + thisEvent.getId()));
		
		if (homeWager > 0.00) {
			Double homeOdds = Double.parseDouble(request.getParameter(homeOddsParam + thisEvent.getId()));
			return userBettingService.createAndSaveBet(thisEvent.getId(), thisEvent.getHomeParticipant(), homeWager, homeOdds);
		} else if (awayWager > 0.00) {
			Double homeOdds = Double.parseDouble(request.getParameter(awayOddsParam  + thisEvent.getId()));
			return userBettingService.createAndSaveBet(thisEvent.getId(), thisEvent.getAwayParticipant(), homeWager, homeOdds);
		}
		return false;
	}

	/**
	 * Process Bet Tips submitted.
	 * @param request
	 * @param lstBetEvents
	 * @param betCompRules
	 */
	private boolean processBetTips(HttpServletRequest request,
			BetEvent thisEvent, BetCompRules betCompRules) {
		String tip = request.getParameter(tipParam + thisEvent.getId());
		if (!StringUtils.isEmpty(tip)) {
			long tipParticipantId = Long.parseLong(tip);
			BetTip betTip = new BetTip();
			betTip.setBetEventId(thisEvent.getId());
			betTip.setCompId(betCompRules.getCompId());
			betTip.setIsOutcomePending(true);
			betTip.setSelectionId(tipParticipantId);
			betTip.setUserId(SecurityUtil.getCurrentUserId());
			betTip.setParentRoundId(thisEvent.getParentRoundId());
			return userBettingService.createBetTip(betTip);
		}
		return false;
	}

	/**
	 * Generates the BetEventViewHelper to be displayed on-screen.
	 * @return
	 */
	private BetEventViewHelper constructBetEventViewHelper(BetEvent betEvent, BetTip betTip, Bet bet) {
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
		if (bet != null) {
			viewHelper.setBetValue(bet.getStake());
		}
		if (betTip != null) {
			viewHelper.setSelectionId(betTip.getSelectionId());
		}
		return viewHelper;
	}
	
	/**
	 * Creates the List of rounds so that it may be displayed in a 3 column table.
	 * @param lstRounds
	 * @return
	 */
	private Map<Integer, List<Round>> createMapOfRounds(List<Round> lstRounds) {
		Map<Integer, List<Round>> retVal = new HashMap<Integer, List<Round>>();
		
		for (int i = 0; i < lstRounds.size() / 3; i++) {
			List<Round> subListRounds = new ArrayList<Round>();
			for (int x = i * 3; x < (i * 3) + 3; x++) {
				subListRounds.add(lstRounds.get(x));
			}
			retVal.put(i, subListRounds);
		}
		
		return retVal;
	}
	
	/**
	 * Grabs the Bet for the bet event.
	 * @param betEvent
	 * @param lstBets
	 * @return
	 */
	private Bet getBetFromList(BetEvent betEvent, List<Bet> lstBets) {
		for (Bet thisBet : lstBets) {
			if (thisBet.getBetEventId() == betEvent.getId()) {
				return thisBet;
			}
		}
		return null;
	}
	
	/**
	 * Grabs the BetTip for the bet event.
	 * @param betEvent
	 * @param lstBetTips
	 * @return
	 */
	private BetTip getBetTipFromList(BetEvent betEvent, List<BetTip> lstBetTips) {
		for (BetTip thisBetTip : lstBetTips) {
			if (thisBetTip.getBetEventId() == betEvent.getId()) {
				return thisBetTip;
			}
		}
		return null;
	}
	
	/**
	 * Gets the bet event ids for the given list.
	 * @param lstEvents
	 * @return
	 */
	private List<Long> getIdsFromEvents(List<BetEvent> lstEvents) {
		List<Long> lstIds = new ArrayList<Long>();
		for (BetEvent betEvent : lstEvents) {
			lstIds.add(betEvent.getId());
		}
		return lstIds;
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

