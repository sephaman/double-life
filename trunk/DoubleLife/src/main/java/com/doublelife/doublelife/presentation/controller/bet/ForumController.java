package com.doublelife.doublelife.presentation.controller.bet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.data.BetComp.ForumEntry;
import com.doublelife.doublelife.data.BetComp.ForumTopic;
import com.doublelife.doublelife.services.ForumService;
import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * Handles Forum requests.
 */
@Controller
public class ForumController {

	@Autowired
	private ForumService forumService;

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	/**
	 * Returns the forum page.
	 * @return 
	 */
	@RequestMapping(value="/viewForum.htm", method=RequestMethod.GET)
	public ModelAndView showForum() {
		logger.info("view forum : GET");
		ModelMap map = new ModelMap();
		
		List<ForumTopic> lstTopics = forumService.getAllForumTopics();
		
		map.addAttribute("topics", lstTopics);
		
		return new ModelAndView("viewForum.tvw", map);
	}
	
	/**
	 * Returns the posts for a forum topic page.
	 * @param topicId 
	 * @return 
	 */
	@RequestMapping(value="/viewForumTopic.htm", method=RequestMethod.GET)
	public ModelAndView showForumTopic(@RequestParam("topicId") long topicId) {
		logger.info("show forum topic : GET");
		ModelMap map = new ModelMap();
		ForumTopic forumTopic = forumService.getForumTopicById(topicId);
		List<ForumEntry> lstEntries = forumService.getForumEntries(topicId);

		map.addAttribute("entries", lstEntries);
		map.addAttribute("forumTopic", forumTopic);

		return new ModelAndView("viewForumTopic.tvw", map);
	}
	
	/**
	 * Returns the posts for a forum topic page.
	 * @param topicId 
	 * @param forumPost 
	 * @return 
	 */
	@RequestMapping(value="/viewForumTopic.htm", method=RequestMethod.POST)
	public ModelAndView addForumTopic(@RequestParam("topicId") long topicId, @RequestParam("forumPost") String forumPost) {
		logger.info("show forum topic : GET");
		
		ForumEntry forumEntry = new ForumEntry();
		forumEntry.setForumPost(forumPost);
		forumEntry.setTopicId(topicId);
		forumEntry.setUserId(SecurityUtil.getCurrentUserId());
		forumEntry.setUserName(SecurityUtil.getCurrentUser().getUserName());

		forumService.addForumEntry(forumEntry);
		
		return showForumTopic(topicId);
	}
}
