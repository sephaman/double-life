/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.ForumEntry;
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
	
	/**
	 * Gets the forum entries for a given topic id.
	 * @return
	 */
	public List<ForumEntry> getForumEntries(long topicId);
	
	/**
	 * Get forum topic by id.
	 * @param forumTopicId
	 * @return
	 */
	public ForumTopic getForumTopicById(long forumTopicId);
	
	/**
	 * Add forum entry to topic.
	 * @param forumEntry
	 * @return
	 */
	public boolean addForumEntry(ForumEntry forumEntry);
}
