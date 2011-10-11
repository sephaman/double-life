/**
 * 
 */
package com.doublelife.doublelife.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetEvent;
import com.doublelife.doublelife.data.BetComp.BetEventType;
import com.doublelife.doublelife.data.BetComp.BetParticipant;
import com.doublelife.doublelife.data.BetComp.BetResult;
import com.doublelife.doublelife.services.UserBettingService;



/**
 * @author Joseph McAleer
 *
 */
@ContextConfiguration(locations = { "/servlet-context-TEST.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserBettingServiceTest {

	@Autowired
	private UserBettingService userBettingService;

	/**
	 * Initial integration test for making and processing a bet.
	 */
	@Test
	public void testProcessBetCreation() {
		//make a bet type
		BetEventType betEventType = new BetEventType();
		betEventType.setName("Football");
		betEventType.setUpdateDateTime(new Date());
		userBettingService.addBetEventType(betEventType);

		//Make some bet participants
		BetParticipant betParticipant = new BetParticipant();
		betParticipant.setName("Joe");
		betParticipant.setUpdateDateTime(new Date());
		userBettingService.addBettingParticipant(betParticipant);
		
		//make a bet event
		BetEvent betEvent = new BetEvent();
		betEvent.setDateTime(new Date());
		betEvent.setBetEventTypeId(betEventType.getId());
		betEvent.setOutcomePending(0);
		betEvent.getLstBetParticipant().add(betParticipant);
		userBettingService.addBetEvent(betEvent);
		
		//make a bet
		Bet bet = new Bet();
		bet.setBetEventId(betEvent.getId());
		bet.setDateReceived(new Date());
		bet.setBetResult(BetResult.PENDING);
		bet.setOddsString("1:2");
		bet.setSelectionId(betParticipant.getId());
		bet.setStake(100.00);
		userBettingService.createBet(bet);
		
		//update the bet event with result
		
		//process the bets
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
