/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.List;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.dao.UserDAO;
import com.doublelife.doublelife.services.UserService;

/**
 * @author Joseph McAleer
 *
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	/**
	 * @see com.doublelife.doublelife.services.UserService#createUser(com.doublelife.doublelife.data.User)
	 */
	public boolean createUser(User user) {
		return userDAO.createUser(user);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserService#getAllUsers()
	 */
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	/**
	 * @see com.doublelife.doublelife.services.UserService#getUserById(long)
	 */
	public User getUserById(long userId) {
		return userDAO.getUserById(userId);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserService#checkForExistingUser(com.doublelife.doublelife.data.User)
	 */
	public boolean checkForExistingUser(User user) {
		if (userDAO.getUserByUserName(user.getUserName()).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

}
