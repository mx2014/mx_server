package util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import pojo.UserInfo;

public class Interceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(Interceptor.class.getName());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginuserinfo");
		
		if (user == null) {
			logger.log(Level.INFO, "user not login");
			response.sendRedirect("/AHzss/admin/index");
		}
		return true;
		// 如果返回false，则不再调用之后的方�?
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
