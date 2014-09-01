package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.IndexDao;

import pojo.Login;
import pojo.UserInfo;
import service.IndexService;

@Service
public class IndexServiceImpl implements IndexService{
	
	@Resource
	private IndexDao idao;

	@Override
	public void add(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		idao.add(userInfo);
	}

	@Override
	public Login login(String name, String pwd) throws Exception {
		// TODO Auto-generated method stub
		return idao.login(name, pwd);
	}
	

}
