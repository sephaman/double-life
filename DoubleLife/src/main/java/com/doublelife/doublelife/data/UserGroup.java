package com.doublelife.doublelife.data;

import java.util.List;

/**
 * Represents a group of users / partnership / company.
 * @author Joseph McAleer
 *
 */
public class UserGroup {

	private long groupId;
	private String groupName;
	private String groupType;   //enum?
	private List<User> lstUser;
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<User> getLstUser() {
		return lstUser;
	}
	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}
}
