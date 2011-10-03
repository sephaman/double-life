/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.dao.UserDAO;
import com.doublelife.doublelife.services.LoginService;

/**
 * Implementation of the login service.
 * @author Joseph McAleer
 *
 */
public class LoginServiceImpl implements LoginService {

	private UserDAO userDAO;
	
	/**
	 * @see com.doublelife.doublelife.services.LoginService#validatePassword(java.lang.String, com.doublelife.doublelife.data.User)
	 */
	public boolean validatePassword(String password, User user) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
