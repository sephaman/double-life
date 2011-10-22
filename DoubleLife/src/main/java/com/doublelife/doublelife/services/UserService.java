/**
 * 
 */
package com.doublelife.doublelife.services;

import java.util.List;

import com.doublelife.doublelife.data.User;

/**
 * Interface for user services.
 * @author Joseph McAleer
 *
 */
public interface UserService {

	/**
	 * Creates the new user.
	 * @param user
	 * @return
	 */
	public boolean createUser(User user);
	
	
	/**
	 * Gets all users.
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * Gets the user by user id.
	 * @param userId
	 * @return
	 */
	public User getUserById(long userId);
	
	/**
	 * Checks if user already exists by checking user details.
	 * @param user
	 * @return
	 */
	public boolean checkForExistingUser(User user);
	
	/**
	 * Gets a user by username.
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
}
