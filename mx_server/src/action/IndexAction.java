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
import util.Sort;

@Controller
public class IndexAction {
	
	@Resource
	public IndexService is;
	
	UserInfo userinfo=new UserInfo();
	
	Login login= new Login();
	
	LoginInfo logininfo= new LoginInfo();
	
	Sort sort=new Sort();
	
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
		String[] toSort = new String[] {"user_name"+"="+user_name+"","pwd"+"="+pwd+""};
		toSort=sort.utilSort(toSort);
		String sortString=toSort[0]+"&"+toSort[1];
		md5.getMD5Str(sortString);
		
		System.out.println(request.getQueryString());
		if(md5.getMD5Str(sortString).equals(key)){
		login = is.login(user_name, pwd);
		if (login != null) {
			md5.getMD5Str(user_name);
			login.setUser_name(user_name);
			login.setPwd(pwd);
			logininfo.setSuccess(true);
			logininfo.setContent(login);
			logininfo.setMsg("登陆成功");
			logininfo.setKey(key);
			return logininfo;
		} else {
			logininfo.setSuccess(false);
			logininfo.setMsg("登陆失败");
			return logininfo;
		}
		} else{
			logininfo.setSuccess(false);
			logininfo.setMsg("被篡改");
			return logininfo;
		}
	}
}

