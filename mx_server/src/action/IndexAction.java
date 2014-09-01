package action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pojo.Login;
import pojo.LoginInfo;
import pojo.UserInfo;
import service.IndexService;
import util.Md5;

@Controller
public class IndexAction {
	
	@Resource
	public IndexService is;
	
	UserInfo userinfo=new UserInfo();
	
	Login login= new Login();
	
	LoginInfo logininfo= new LoginInfo();
	
	Md5 md5=new Md5();

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) throws Exception {
		return new ModelAndView("/home/html/index");
	}
	
	@RequestMapping(value = "index2", method = RequestMethod.GET)
	public ModelAndView aaa(
			@RequestParam("user_name") String user_name,
			@RequestParam("iphone_type") Integer iphone_type,
			@RequestParam("login_ip") String login_ip,
			@RequestParam("mac_adress") String mac_adress,
			HttpServletRequest request,
			HttpServletResponse response,
			Object command,
			ModelMap model) throws Exception {
		userinfo.setUser_name(user_name);
		userinfo.setIphone_type(iphone_type);
		userinfo.setLogin_ip(login_ip);
		userinfo.setMac_adress(mac_adress);
		is.add(userinfo);
		response.getWriter().print("{response:'success', text:{}}");
		return new ModelAndView("/home/html/index");
		
		//System.out.println(md5.getMD5Str(user_name));
		//user_name=md5.getMD5Str(user_name);
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public @ResponseBody LoginInfo login(
		   @RequestParam("user_name") String user_name,
		   @RequestParam("pwd") String pwd,
		   @RequestParam("key") String key,
		   HttpServletRequest request,
		   HttpServletResponse response,
		   HttpSession session,
		   ModelMap model)
				   throws Exception {
		login = is.login(user_name, pwd);
		System.out.println(md5.getMD5Str(user_name));
		System.out.println(md5.getMD5Str(pwd));
		if (login != null) {
			md5.getMD5Str(user_name);
			login.setUser_name(user_name);
			login.setPwd(pwd);
			logininfo.setSuccess(true);
			logininfo.setContent(login);
			logininfo.setMsg("登陆成功");
			logininfo.setKey(key);
			return logininfo;
		
			//System.out.println("登陆成功");
			//System.out.println(login);
			//System.out.println(key);
			//System.out.println(login);
			//System.out.println(user_name);
			//System.out.println(pwd);
			//System.out.println("---------------------------------");
			//json="{\"success\":\"true\",\"content\"=[{\"name\":\" "+user_name+" \",\"pwd\":\" "+pwd+" \",\"key\":\"  "+key+"   \"}],\"msg\":\"登陆成功!\"}";
			//request.setAttribute("login", "登陆成功");
			//System.out.println(json);
		} else {
			logininfo.setSuccess(false);
			logininfo.setMsg("登陆失败");
			return logininfo;
			
			//System.out.println("登陆失败");
			//json="{\"success\":true,\"msg\":\"登陆失败!\",\"key\":\"  "+key+"   \"}";
			//request.setAttribute("login", "登陆失败");
			//System.out.println(json);
		}
	}
}

