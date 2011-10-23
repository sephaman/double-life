package com.doublelife.doublelife.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the Double life home page.
 */
@Controller
public class DoubleLifeHomeController {

	private static final Logger logger = LoggerFactory.getLogger(DoubleLifeHomeController.class);

	/**
	 * Gets the main menu for double life.
	 * @return 
	 */
	@RequestMapping(value="/doubleLifeHome.htm", method=RequestMethod.GET)
	public ModelAndView doubleLifeHome() {
		logger.info("DoubleLife Home Controller : GET");
		ModelMap map = new ModelMap();
		
		return new ModelAndView("doubleLifeHome.tvw", map);
	}
}

