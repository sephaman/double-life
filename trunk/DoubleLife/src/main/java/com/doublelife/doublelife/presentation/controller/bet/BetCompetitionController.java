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

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.services.UserBettingService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Handles requests for displaying betting competitions.
 */
@Controller
public class BetCompetitionController {

	@Autowired
	private UserBettingService userBettingService;
	
	private static final Logger logger = LoggerFactory.getLogger(BetCompetitionController.class);

	/**
	 * Returns a list of bet competitions.
	 * @return 
	 */
	@RequestMapping(value="/betCompsView.htm", method=RequestMethod.GET)
	public ModelAndView showBetCompetitions() {
		logger.info("Bet Comps Controller : GET");
		ModelMap map = new ModelMap();
		map.addAttribute("betComps", userBettingService.getAllCurrentCompetitions());
		return new ModelAndView("betCompsView.tvw", map);
	}
	
	/**
	 * Allows user to join the competition.
	 * @param compId 
	 * @return 
	 */
	@RequestMapping(value="/betCompsJoin.htm", method=RequestMethod.GET)
	public ModelAndView joinBetCompetition(@RequestParam("id") long compId) {
		logger.info("Bet Comps Controller join: GET");
		BetCompetition betComp = userBettingService.getCompetitionById(compId);
		ModelMap map = new ModelMap();
		if (!betCompContainsUser(betComp)) {
			betComp.getLstUser().add(SecurityUtil.getCurrentUser());
			userBettingService.createBetCompetition(betComp);
			userBettingService.createNewBettingAccount(betComp, SecurityUtil.getCurrentUserId());
			
			map.addAttribute("registered", true);
			map.addAttribute("joinedComp", betComp);
			return new ModelAndView("betCompsSuccessJoinView.tvw", map);
		} else {
			map.addAttribute("errorMsg", "Already registered for this competition!");
			map.addAttribute("betComps", userBettingService.getAllCurrentCompetitions());
			return new ModelAndView("betCompsView.tvw", map);
		}
	}
	
	/**
	 * Returns true if user is in the competition already.
	 * @param betComp
	 * @return
	 */
	private boolean betCompContainsUser(BetCompetition betComp) {
		
		for (User thisUser : betComp.getLstUser()) {
			if (thisUser.getId() == SecurityUtil.getCurrentUserId()) {
				return true;
			}
		}
		
		return false;
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

