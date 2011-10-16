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
	 * Creates the given user.
	 * @param user 
	 * @return
	 */
	public boolean createUser(User user);
	
	/**
	 * Returns a password for a user.
	 * @param user
	 * @return
	 */
	public String getUserPassword(User user);
	
	/**
	 * Get the user by Id.
	 * @param id
	 * @return
	 */
	public User getUserById(long userId);
}
