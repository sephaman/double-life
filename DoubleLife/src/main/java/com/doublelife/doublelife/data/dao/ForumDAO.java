/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.BetComp.ForumEntry;
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

	/**
	 * Gets the forum entries for a given toipic id.
	 * @param topicId
	 * @return
	 */
	public List<ForumEntry> getForumEntries(long topicId);

	/**
	 * Gets forum topic by id.
	 * @param forumTopicId
	 * @return
	 */
	public ForumTopic getForumTopicById(long forumTopicId);
	
	/**
	 * Adds a new forum entry.
	 * @param forumEntry
	 * @return
	 */
	public boolean addForumEntry(ForumEntry forumEntry);
}
