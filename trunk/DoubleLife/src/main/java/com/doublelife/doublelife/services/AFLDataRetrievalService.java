/**
 * 
 */
package com.doublelife.doublelife.services;

import com.doublelife.doublelife.data.BetComp.Round;

/**
 * Service interface for retrieving AFL information.
 * @author Joseph McAleer
 *
 */
public interface AFLDataRetrievalService {

	/**
	 * Retrieves the round.
	 * @param roundId
	 * @return
	 */
	Round getRound(int roundId);
}
