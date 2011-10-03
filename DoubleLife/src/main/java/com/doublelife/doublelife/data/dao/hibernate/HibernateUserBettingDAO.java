/**
 * 
 */
package com.doublelife.doublelife.data.dao.hibernate;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.Bet;
import com.doublelife.doublelife.data.dao.UserBettingDAO;

/**
 * @author Joseph McAleer
 *
 */
public class HibernateUserBettingDAO implements UserBettingDAO {

	/* (non-Javadoc)
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getUserPendingBets(long)
	 */
	@Override
	public List<Bet> getUserPendingBets(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getUserPendingBetCount(long)
	 */
	@Override
	public int getUserPendingBetCount(long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.doublelife.doublelife.data.dao.UserBettingDAO#getAllUserBets(long)
	 */
	@Override
	public List<Bet> getAllUserBets(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
