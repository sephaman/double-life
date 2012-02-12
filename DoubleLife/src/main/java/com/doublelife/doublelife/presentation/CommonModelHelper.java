/**
 * 
 */
package com.doublelife.doublelife.presentation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.BetComp.BetCompRules;
import com.doublelife.doublelife.data.BetComp.BetCompetition;
import com.doublelife.doublelife.services.utils.PersistenceUtil;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * @author Joseph McAleer
 *
 */
public final class CommonModelHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonModelHelper.class);

    private static List<String> lstBetViewNames;
    private static List<String> lstDLViewNames;
    
	private CommonModelHelper() {
		// cannot be instantiated by others
	}

	/**
	 * Fills the given <code>ModelAndView</code> object with common attributes.
	 * If the passed <code>ModelAndView</code> object is a null reference,
	 * this method returns <code>null</code>.
	 *
	 * @param modelAndView the <code>ModelAndView</code> object to fill.
	 * @return the filled <code>ModelAndView</code> object.
	 */
	public static ModelAndView fillCommonAttributes(final ModelAndView modelAndView) {
		setupBetViewNames();
		setupDLViewNames();
		if (modelAndView != null) {
			
			User user = SecurityUtil.getCurrentUser();
			if (user != null) {
				modelAndView.addObject("username_head", user.getUserName());
			}
			
			List<String> lstRoles = SecurityUtil.getCurrentUserRoleNames();
			if (lstRoles.size() > 0) {
				modelAndView.addObject("rolename",lstRoles.get(0)); 
				}
			
			BetCompetition betComp = PersistenceUtil.getUserBettingDAOImpl().getCompetitionById(1);
			modelAndView.addObject("betComp",betComp);
			
			if (betComp != null) {
				BetCompRules betCompRules = PersistenceUtil.getUserBettingDAOImpl().getBetCompRulesByCompId(betComp.getId());
				modelAndView.addObject("betCompRules",betCompRules);
			}
			if (user != null) {
				
				modelAndView.addObject("userAccount_head", PersistenceUtil.getUserBettingDAOImpl().getUserBettingAccountByUserId(user.getId(), betComp.getId()).getAmountAvailable());
				
				modelAndView.addObject("pendingBets_head", PersistenceUtil.getUserBettingDAOImpl().getUserPendingBetCount(user.getId()));
				
			}
			//set up menu
			if (lstBetViewNames.contains(modelAndView.getViewName())) {
				modelAndView.addObject("menuType", "bet");
			} else if (lstDLViewNames.contains(modelAndView.getViewName())) {
				modelAndView.addObject("menuType", "dl");
			}
		}

		return modelAndView;
	}
	
	/**
	 * DL View names setup.
	 */
	private static void setupDLViewNames() {
		lstDLViewNames = new ArrayList<String>();
		lstDLViewNames.add("doubleLifeHome.tvw");
		lstDLViewNames.add("stockSearch.tvw");
		lstDLViewNames.add("stockOrder.tvw");
		lstDLViewNames.add("stockOrderConfirmation.tvw");
		lstDLViewNames.add("userStockPortfolio.tvw");
		lstDLViewNames.add("dlCompsView.tvw");
		lstDLViewNames.add("dlCompsCreate.tvw");
		lstDLViewNames.add("dlCompsSuccessJoinView.tvw");
	}

	/**
	 * Bet view names set up.
	 */
	private static void setupBetViewNames() {
		lstBetViewNames = new ArrayList<String>();
		lstBetViewNames.add("fantasyBetHome.tvw");
		lstBetViewNames.add("userBets.tvw");
		lstBetViewNames.add("betViewer.tvw");
		lstBetViewNames.add("userBetAccount.tvw");
		lstBetViewNames.add("betCompsView.tvw");
		lstBetViewNames.add("betCompsSuccessJoinView.tvw");
		lstBetViewNames.add("betCompsCreate.tvw");
		lstBetViewNames.add("betEventsView.tvw");
		lstBetViewNames.add("createBetEvent.tvw");
		lstBetViewNames.add("updateBetEvent.tvw");
		lstBetViewNames.add("selectWinnerBetEvent.tvw");
		lstBetViewNames.add("betCompLeaderboardView.tvw");
		lstBetViewNames.add("createSeason.tvw");
		lstBetViewNames.add("createRound.tvw");
		lstBetViewNames.add("viewAllSeasons.tvw");
		lstBetViewNames.add("viewSeason.tvw");
		lstBetViewNames.add("viewRound.tvw");
		lstBetViewNames.add("userDetails.tvw");
		lstBetViewNames.add("userResetPwd.tvw");
	}
}
