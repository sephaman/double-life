/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.Competition;

/**
 * DAO for Double Life Competitions.
 * @author Joseph McAleer
 *
 */
public interface CompetitionDAO {

	/**
	 * Gets all competitions.
	 * @return
	 */
	public List<Competition> getAllCurrentCompetitions();
	
	/**
	 * Gets the Competition by the id.
	 * @param id
	 * @return
	 */
	public Competition getCompetitionById(long id);
	
	/**
	 * Create new Competition.
	 * @param competition
	 * @return
	 */
	public boolean createCompetition(Competition competition);
}
