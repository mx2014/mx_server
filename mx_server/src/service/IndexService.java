package service;

import pojo.Login;
import pojo.UserInfo;

public interface IndexService {
	public void add(UserInfo userInfo) throws Exception;
	
	public Login login(String user_name,String pwd) throws Exception;
}
