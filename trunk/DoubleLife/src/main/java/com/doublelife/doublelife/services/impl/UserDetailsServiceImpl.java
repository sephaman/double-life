package com.doublelife.doublelife.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.doublelife.doublelife.data.AuthorisedUser;
import com.doublelife.doublelife.data.Role;
import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.services.UserService;

/**
 * Spring UserDetailsService implementation.
 * @author Joseph McAleer
 */
public class UserDetailsServiceImpl implements UserDetailsService, Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserService userService;

	@Override
	@SuppressWarnings({"serial" })
	public UserDetails loadUserByUsername(String userLogon)
			throws UsernameNotFoundException, DataAccessException {
		User user = userService.getUserByUserName(userLogon);
		
		//get the role for this user
		Role role = userService.getUserRole(user.getRoleId());
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new GrantedAuthorityImpl(role.getRole()));
			
			String userPassword = user.getPassword();
		return
			new AuthorisedUser (
					user.getUserName(), userPassword, true,
						true, true, true, grantedAuthorities, user) {
							
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
