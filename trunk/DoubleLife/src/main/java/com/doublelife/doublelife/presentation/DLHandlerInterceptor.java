/**
 * 
 */
package com.doublelife.doublelife.presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Joseph McAleer
 *
 */
public class DLHandlerInterceptor extends HandlerInterceptorAdapter {

		/**
		 * Injects common attributes to the model and view
		 * produced by any request handler.
		 *
		 * @param request current HTTP request.
		 * @param response current HTTP response.
		 * @param handler chosen handler to execute, for type and/or instance examination.
		 * @param modelAndView the <code>ModelAndView</code> that the handler returned (can also be <code>null</code>).
		 * @throws Exception in case of errors.
		 */
		@Override
		public void postHandle(HttpServletRequest request,
				HttpServletResponse response,
				Object handler,
				ModelAndView modelAndView) throws Exception {

			super.postHandle(request, response, handler, modelAndView);
			CommonModelHelper.fillCommonAttributes(modelAndView);
		}
}
