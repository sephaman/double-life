/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.List;

import com.doublelife.doublelife.data.Competition;
import com.doublelife.doublelife.data.dao.CompetitionDAO;
import com.doublelife.doublelife.services.CompetitionService;

/**
 * @author Joseph McAleer
 *
 */
public class CompetitionServiceImpl implements CompetitionService {

	private CompetitionDAO competitionDAO;
	
	/**
	 * @see com.doublelife.doublelife.services.CompetitionService#getAllCurrentCompetitions()
	 */
	public List<Competition> getAllCurrentCompetitions() {
		return competitionDAO.getAllCurrentCompetitions();
	}

	/**
	 * @see com.doublelife.doublelife.services.CompetitionService#getCompetitionById(long)
	 */
	public Competition getCompetitionById(long id) {
		return competitionDAO.getCompetitionById(id);
	}

	/**
	 * @see com.doublelife.doublelife.services.CompetitionService#createCompetition(com.doublelife.doublelife.data.Competition)
	 */
	public boolean createCompetition(Competition competition) {
		return competitionDAO.createCompetition(competition);
	}

	/**
	 * @param competitionDAO the competitionDAO to set
	 */
	public void setCompetitionDAO(CompetitionDAO competitionDAO) {
		this.competitionDAO = competitionDAO;
	}

	/**
	 * @return the competitionDAO
	 */
	public CompetitionDAO getCompetitionDAO() {
		return competitionDAO;
	}

}
