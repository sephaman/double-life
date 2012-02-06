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
import com.doublelife.doublelife.services.EmailService;
import com.doublelife.doublelife.services.UserService;

/**
 * Handles requests for the user registration page.
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
	
	@Autowired
	private EmailService emailService;
	
	/**
	 * Displays the user registration page.
	 * @return 
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
	 * Validates the user and creates it. Returns success view.
	 * @param user 
	 * @param result 
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleSubmit(@ModelAttribute("user") User user, BindingResult result) {
		logger.info("User Registration Submission");
		userValidator.validate(user, result);
		if (userService.checkForExistingUser(user)) {
			result.reject("userName", "Username already exists");
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("userRegistration.tvw");
		} else {
			user.setRoleId(0);
			boolean createResult = userService.createUser(user);  //TODO: handle failures
			emailService.sendMail("Welcome to Tip n' Trade!", getWelcomeEmailText(user), user.getEmailAddress());
			return new ModelAndView("userRegistrationSuccess.tvw");
		}
	}

	/**
	 * Generates the email text for the welcome message.
	 * @param user
	 * @return
	 */
	private String getWelcomeEmailText(User user) {
		String txt ="Hey there " + user.getFirstName() + "! Welcome to Tip n' Trade\r\n\r\n";
		
		txt += "This email confirms your registration.\r\n\r\n Good luck!";
		
		return txt;
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

	/**
	 * @return the emailService
	 */
	public EmailService getEmailService() {
		return emailService;
	}

	/**
	 * @param emailService the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
}

