/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.ForumTopic;
import com.doublelife.doublelife.data.dao.ForumDAO;
import com.doublelife.doublelife.services.ForumService;


/**
 * Implementation of forum service.
 * @author Joseph McAleer
 *
 */
public class ForumServiceImpl implements ForumService {

	private ForumDAO forumDAO;
	
	/**
	 * @see com.doublelife.doublelife.services.ForumService#getAllForumTopics()
	 */
	public List<ForumTopic> getAllForumTopics() {
		return forumDAO.getAllForumTopics();
	}

	/**
	 * @see com.doublelife.doublelife.services.ForumService#addForumTopic(com.doublelife.doublelife.data.BetComp.ForumTopic)
	 */
	public boolean addForumTopic(ForumTopic forumTopic) {
		return forumDAO.addForumTopic(forumTopic);
	}
	
	/**
	 * @return the forumDAO
	 */
	public ForumDAO getForumDAO() {
		return forumDAO;
	}

	/**
	 * @param forumDAO the forumDAO to set
	 */
	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}

}
