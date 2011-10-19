package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserRegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/userRegistration", method=RequestMethod.GET)
	public ModelAndView initUserRegistrationPage() {
		logger.info("Welcome to user registration!");
		ModelMap map = new ModelMap();
		
		return new ModelAndView("userRegistration.tvw", map);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/userRegistration", method=RequestMethod.POST)
	public ModelAndView handleSubmit() {
		logger.info("User Registration Submission");
		ModelMap map = new ModelMap();
		
		return new ModelAndView("userRegistration.tvw", map);
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}
	
}

