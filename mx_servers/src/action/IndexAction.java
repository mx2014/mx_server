package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pojo.UserInfo;

import service.IndexService;

@Controller
public class IndexAction {
	
	@Resource
	public IndexService is;
	
	UserInfo userinfo=new UserInfo();

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) throws Exception {
		return new ModelAndView("/home/html/index");
	}
	
	@RequestMapping(value = "aaa", method = RequestMethod.GET)
	public ModelAndView aaa(
			@RequestParam("user_name") String user_name,
			@RequestParam("iphone_type") Integer iphone_type,
			@RequestParam("login_ip") String login_ip,
			@RequestParam("mac_adress") String mac_adress,
			ModelMap model) throws Exception {
		userinfo.setUser_name(user_name);
		userinfo.setIphone_type(iphone_type);
		userinfo.setLogin_ip(login_ip);
		userinfo.setMac_adress(mac_adress);
		is.add(userinfo);
		return new ModelAndView("/home/html/index");
	}
}

