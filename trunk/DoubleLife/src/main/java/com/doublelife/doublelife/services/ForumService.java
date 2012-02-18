/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.ForumTopic;

/**
 * Interface for Forum Services.
 * @author Joseph McAleer
 *
 */
public interface ForumService {

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
