package com.doublelife.doublelife.data.BetComp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a Forum Entry.
 * @author Joseph McAleer
 *
 */
@Entity (name = "forum_entry")
public class ForumEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "datetime")
	private Date dateTime;
	
	@Column(name = "forum_topic_id")
	private long topicId;
	
	@Column(name = "userid")
	private long userId;
	
	@Column(name = "forum_post")
	private String forumPost;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the createDateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the topicId
	 */
	public long getTopicId() {
		return topicId;
	}

	/**
	 * @param topicId the topicId to set
	 */
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	/**
	 * @return the forumPost
	 */
	public String getForumPost() {
		return forumPost;
	}

	/**
	 * @param forumPost the forumPost to set
	 */
	public void setForumPost(String forumPost) {
		this.forumPost = forumPost;
	}

	
	
}
