/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import com.doublelife.doublelife.data.User;

/**
 * The DAO for the User table.
 * @author Joseph McAleer
 *
 */
public interface UserDAO {

	/**
	 * Returns a password for a user.
	 * @param user
	 * @return
	 */
	public String getUserPassword(User user);
}
