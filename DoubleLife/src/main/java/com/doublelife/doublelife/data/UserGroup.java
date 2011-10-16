package com.doublelife.doublelife.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Represents a group of users / partnership / company.
 * @author Joseph McAleer
 *
 */
@Entity (name = "user_group")
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "competitonId")
	private long competitionId;
	
	@Column(name = "groupName")
	private String groupName;
	
	@ManyToMany
	@JoinTable (
	name = "usergroup_user",
	joinColumns = {@JoinColumn(name = "groupId")} ,
	inverseJoinColumns ={@JoinColumn(name = "userId")}
	)
	private List<User> lstUser;
	
	/**
	 * @return
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return
	 */
	public List<User> getLstUser() {
		return lstUser;
	}
	/**
	 * @param lstUser
	 */
	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param competitionId the competitionId to set
	 */
	public void setCompetitionId(long competitionId) {
		this.competitionId = competitionId;
	}
	/**
	 * @return the competitionId
	 */
	public long getCompetitionId() {
		return competitionId;
	}
}
