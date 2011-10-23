/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.Competition;

/**
 * Service interface for double life competitions.
 * @author Joseph McAleer
 *
 */
public interface CompetitionService {

	/**
	 * Gets all betting competitions.
	 * @return
	 */
	public List<Competition> getAllCurrentCompetitions();
	
	/**
	 * Gets the competition by the id.
	 * @param id
	 * @return
	 */
	public Competition getCompetitionById(long id);
	
	/**
	 * Create new competition.
	 * @param competition
	 * @return
	 */
	public boolean createCompetition(Competition competition);
}
