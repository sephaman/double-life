/**
 * 
 */
package com.doublelife.doublelife.data.dao;

import java.util.List;

import com.doublelife.doublelife.data.Role;
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
	 * @param userId 
	 * @return
	 */
	public User getUserById(long userId);
	
	/**
	 * Returns all users.
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * @param userName
	 * @return
	 */
	public List<User> getUserByUserName(String userName);

	/**
	 * Gets the role for the user.
	 * @param userRoleId
	 * @return
	 */
	public Role getUserRole(long userRoleId);
}
