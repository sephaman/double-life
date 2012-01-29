/**
 * 
 */
package com.doublelife.doublelife.presentation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.doublelife.doublelife.services.utils.SecurityUtil;

/**
 * @author Joseph McAleer
 *
 */
public final class CommonModelHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonModelHelper.class);

	private CommonModelHelper() {
		// cannot be instantiated by others
	}

	/**
	 * Fills the given <code>ModelAndView</code> object with common attributes.
	 * If the passed <code>ModelAndView</code> object is a null reference,
	 * this method returns <code>null</code>.
	 *
	 * @param modelAndView the <code>ModelAndView</code> object to fill.
	 * @return the filled <code>ModelAndView</code> object.
	 */
	public static ModelAndView fillCommonAttributes(final ModelAndView modelAndView) {

		if (modelAndView != null) {
			List<String> lstRoles = SecurityUtil.getCurrentUserRoleNames();
			if (lstRoles.size() > 0) {modelAndView.addObject("rolename",lstRoles.get(0)); }
		}

		return modelAndView;
	}
}
