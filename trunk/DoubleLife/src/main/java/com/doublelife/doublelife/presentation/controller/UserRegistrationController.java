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
	@RequestMapping(value="/userRegistration.htm", method=RequestMethod.GET)
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
	@RequestMapping(value="/userRegistration.htm", method=RequestMethod.POST)
	public ModelAndView handleSubmit(@ModelAttribute("user") User user, BindingResult result) {
		logger.info("User Registration Submission");
		userValidator.validate(user, result);
		if (userService.checkForExistingUser(user)) {
			result.rejectValue("userName", "username.exist");
		}
		if (userService.getUserByEmail(user.getEmailAddress()) != null) {
			result.rejectValue("emailAddress", "email.exist");
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
	 * Displays the forgot password page.
	 * @param user 
	 * @param result 
	 * @return 
	 */
	@RequestMapping(value="/forgotPassword.htm", method=RequestMethod.GET)
	public ModelAndView showForgotPassword() {
		logger.info("User Forgot Password");
		ModelMap map = new ModelMap();
		User user = new User();
		map.addAttribute("user", user);
		return new ModelAndView("forgotPassword.tvw", map);
	}
	
	/**
	 * Displays the forgot password page.
	 * @param user 
	 * @param result 
	 * @return 
	 */
	@RequestMapping(value="/forgotPassword.htm", method=RequestMethod.POST)
	public ModelAndView submitForgotPassword(@ModelAttribute("user") User user) {
		logger.info("User Forgot Password Submit");
		boolean result = false;
		User retrievedUser = userService.getUserByEmail(user.getEmailAddress());
		ModelMap map = new ModelMap();
		if (retrievedUser != null) {
			Double randomVal = Math.random() * 1000;
			String newPw = "newPassword" + randomVal.intValue();
			result = userService.updateUserPassword(retrievedUser, newPw);
			if (result == true) {
				emailService.sendMail("Tip n' Trade Password Reset", getForgotPwdEmailText(retrievedUser, newPw), user.getEmailAddress());
			}
		} else {
			map.addAttribute("errorMsg", "User with submitted email address " + user.getEmailAddress() + " not found");
		}
		
		map.addAttribute("user", retrievedUser);
		map.addAttribute("success", result);
		return new ModelAndView("forgotPassword.tvw", map);
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
	
	private String getForgotPwdEmailText(User user, String newPw) {
		String txt = "Here are your login details for Tip n' Trade\r\n\r\n";
		txt += "Username: " + user.getUserName() + "\r\n\r\n";
		txt += "Password: " + newPw;
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

