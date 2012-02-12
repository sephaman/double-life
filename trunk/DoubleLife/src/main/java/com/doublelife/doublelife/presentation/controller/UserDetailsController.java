package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.services.UserService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Handles requests for the user details page.
 */
@Controller
public class UserDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

	@Autowired
	private UserService userService;
	
	/**
	 * Gets the user details page.
	 * @return 
	 */
	@RequestMapping(value="/userDetails.htm", method=RequestMethod.GET)
	public ModelAndView userDetailsShow() {
		logger.info("UserDetails Controller : GET");
		ModelMap map = new ModelMap();
		
		map.addAttribute("user", userService.getUserById(SecurityUtil.getCurrentUserId()));
		return new ModelAndView("userDetails.tvw", map);
	}
	
	/**
	 * Gets the main menu for fantasy betting.
	 * @return 
	 */
	@RequestMapping(value="/resetUserPwd.htm", method=RequestMethod.POST)
	public ModelAndView resetUserPaswordShow(@RequestParam("userId") long userId) {
		logger.info("Reset user pwd Controller : POST");
		ModelMap map = new ModelMap();
		
		map.addAttribute("user", userService.getUserById(SecurityUtil.getCurrentUserId()));
		return new ModelAndView("userResetPwd.tvw", map);
	}
	
	/**
	 * Gets the main menu for fantasy betting.
	 * @return 
	 */
	@RequestMapping(value="/resetUserPwdSubmit.htm", method=RequestMethod.POST)
	public ModelAndView resetUserPaswordSubmit(@RequestParam("currentPwd") String currentPwd, 
			@RequestParam("newPwd") String newPwd,
			@RequestParam("confirmPwd") String confirmPwd) {
		logger.info("Submit Reset user pwd Controller : POST");
		ModelMap map = new ModelMap();
		User retrievedUser = userService.getUserById(SecurityUtil.getCurrentUserId());
		map.addAttribute("user", retrievedUser);
		
		if (userService.checkPassword(retrievedUser, currentPwd) == false) {
			map.addAttribute("errorMsg", "Current Password is incorrect");
			return new ModelAndView("userResetPwd.tvw", map);
		} else if (!newPwd.equals(confirmPwd)) {
			map.addAttribute("errorMsg", "Confirm password doesn't match new password");
			return new ModelAndView("userResetPwd.tvw", map);
		} else {
			boolean success = userService.updateUserPassword(retrievedUser, newPwd);
			map.addAttribute("success", success);
			if (success == false) {
				map.addAttribute("errorMsg", "Saving new password failed");
			}
			map.addAttribute("user", retrievedUser);
		}
		return new ModelAndView("userResetPwd.tvw", map);
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

