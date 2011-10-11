/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import com.doublelife.doublelife.data.BetComp.BetCompetition;

/**
 * Interface for providing betting competition DAO functions. 
 * @author Joseph McAleer
 *
 */
public interface BettingCompetitionDAO {

	/**
	 * Creates a betting competition.
	 * @param betCompetition
	 * @return
	 */
	public boolean createCompetition(BetCompetition betCompetition);
}
