package com.doublelife.doublelife.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.services.UserService;

/**
 * Spring UserDetailsService implementation.
 * @author rstsyy
 */
public class UserDetailsServiceImpl implements UserDetailsService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	@Override
	@SuppressWarnings({"PMD.ExcessiveMethodLength", "serial" })
	public UserDetails loadUserByUsername(String userLogon)
			throws UsernameNotFoundException, DataAccessException {
		User user = userService.getUserByUserName(userLogon);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
		return
			new org.springframework.security.core.userdetails.User(
					user.getUserName(), user.getPassword(), true,
						true, true, true, grantedAuthorities) {

						};
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
