/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.BetComp.BetResult;



/**
 * @author Joseph McAleer
 *
 */
@ContextConfiguration(locations = { "/servlet-context-TEST.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
public class UserBettingDAOTest {

	@Autowired
	private UserBettingDAO userBettingDAO;
	
	/**
	 * Tests the DAO's ability to save a bet.
	 */
	@Test
	public void testSaveBet() {
		Bet bet = new Bet();
		bet.setDateReceived(new Date());
		bet.setMoneyPaid(44.55);
		bet.setSelectionId(343);
		bet.setUserId(66);
		bet.setStake(55.00);
		bet.setBetResult(BetResult.PENDING);
		bet.setOddsString("3:4");
		
		Assert.assertTrue(userBettingDAO.saveBet(bet));
	}

	/**
	 * @param userBettingDao the userBettingDao to set
	 */
	public void setUserBettingDAO(UserBettingDAO userBettingDao) {
		this.userBettingDAO = userBettingDao;
	}

	/**
	 * @return the userBettingDao
	 */
	public UserBettingDAO getUserBettingDAO() {
		return userBettingDAO;
	}
}
