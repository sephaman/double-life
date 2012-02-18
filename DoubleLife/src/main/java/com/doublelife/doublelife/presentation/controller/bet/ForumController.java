package com.doublelife.doublelife.presentation.controller.bet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.BetComp.ForumTopic;
import com.doublelife.doublelife.services.ForumService;

/**
 * Handles Forum requests.
 */
@Controller
public class ForumController {

	@Autowired
	private ForumService forumService;

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	/**
	 * Returns the create round form page.
	 * @return 
	 */
	@RequestMapping(value="/viewForum.htm", method=RequestMethod.GET)
	public ModelAndView showForum() {
		logger.info("create Round Controller : GET");
		ModelMap map = new ModelMap();
		
		List<ForumTopic> lstTopics = forumService.getAllForumTopics();
		
		map.addAttribute("topics", lstTopics);
		
		return new ModelAndView("viewForum.tvw", map);
	}
	
}

