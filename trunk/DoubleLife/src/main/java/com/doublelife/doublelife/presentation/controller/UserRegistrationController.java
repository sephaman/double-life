package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.User;
import com.doublelife.doublelife.data.validator.UserValidator;
import com.doublelife.doublelife.services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/userRegistration.htm")
@SessionAttributes("user")
public class UserRegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initUserRegistrationPage() {
		logger.info("Welcome to user registration!");
		User user = new User();
		ModelMap map = new ModelMap();
		map.addAttribute("user", user);
		return new ModelAndView("userRegistration.tvw", map);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleSubmit(@ModelAttribute("user") User user, BindingResult result) {
		logger.info("User Registration Submission");
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("userRegistration.tvw");
		} else {
			boolean createResult = userService.createUser(user);
			
			return new ModelAndView("userRegistrationSuccess.tvw");
		}
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

	/**
	 * @return the userValidator
	 */
	public UserValidator getUserValidator() {
		return userValidator;
	}

	/**
	 * @param userValidator the userValidator to set
	 */
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	
}

