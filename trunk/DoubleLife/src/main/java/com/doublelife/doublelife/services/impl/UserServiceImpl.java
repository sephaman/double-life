/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.doublelife.doublelife.data.Role;
import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.dao.UserDAO;
import com.doublelife.doublelife.services.UserService;

/**
 * @author Joseph McAleer
 *
 */
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * @see com.doublelife.doublelife.services.UserService#createUser(com.doublelife.doublelife.data.User)
	 */
	public boolean createUser(User user) {
		//hash the password
		try {
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), ""));
			return userDAO.createUser(user);
		} catch(Exception ex) {
			logger.error("couldnt hash password while saving user: " + user.getUserName());
			return false;
		}
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

	/**
	 * @see com.doublelife.doublelife.services.UserService#getUserByUserName(java.lang.String)
	 */
	public User getUserByUserName(String userName) {
		List<User> lstUsers = userDAO.getUserByUserName(userName);
		if (lstUsers != null && lstUsers.size() == 1) {
			return lstUsers.get(0);
		}
		return null;
	}

	/**
	 * @see com.doublelife.doublelife.services.UserService#saveUser(com.doublelife.doublelife.data.User)
	 */
	public boolean saveUser(User user) {
		return userDAO.createUser(user);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserService#getUserRole(long)
	 */
	public Role getUserRole(long userRoleId) {
		return userDAO.getUserRole(userRoleId);
	}

	/**
	 * @param passwordEncoder the passwordEncoder to set
	 */
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	

	/**
	 * @see com.doublelife.doublelife.services.UserService#getUserByEmail(java.lang.String)
	 */
	public User getUserByEmail(String emailAddress) {
		return userDAO.getUserByEmail(emailAddress);
	}

	/**
	 * @see com.doublelife.doublelife.services.UserService#updateUserPassword(java.lang.String)
	 */
	public boolean updateUserPassword(User user, String newPw) {
		try {
			user.setPassword(passwordEncoder.encodePassword(newPw, ""));
			return userDAO.updateUser(user);
		} catch(Exception ex) {
			logger.error("couldnt hash password while saving user: " + user.getUserName());
			return false;
		}
	}
	
	public boolean checkPassword(User user, String pwd) {
		return passwordEncoder.isPasswordValid(user.getPassword(), pwd, "");
	}

}
