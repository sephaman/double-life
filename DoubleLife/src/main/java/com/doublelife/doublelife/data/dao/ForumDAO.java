/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.ForumTopic;

/**
 * DAO for the forum.
 * @author Joseph McAleer
 *
 */
public interface ForumDAO {
	/**
	 * Returns all forum topics.
	 * @return
	 */
	public List<ForumTopic> getAllForumTopics();
	
	/**
	 * Adds a new forum topic.
	 * @param forumTopic
	 * @return
	 */
	public boolean addForumTopic(ForumTopic forumTopic);
}
