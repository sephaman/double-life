/**
 * 
 */
package com.doublelife.doublelife.services;

import com.doublelife.doublelife.data.User;

/**
 * Interface for a LoginService.
 * @author Joseph McAleer
 *
 */
public interface LoginService {

	/**
	 * Returns true if password is correct.
	 * @return
	 */
	public boolean validatePassword(String password, User user);
}
