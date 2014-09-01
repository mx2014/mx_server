package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pojo.Login;
import pojo.UserInfo;

import dao.IndexDao;

@Repository
public class IndexDaoImpl extends HibernateDaoSupport implements IndexDao{
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void add(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(userInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Login login(String user_name, String pwd) throws Exception {
		List<Login> loginfoList = this.getHibernateTemplate().find(
				"from Login where user_name=? and pwd=?",
				new Object[] { user_name, pwd });
		if (null == loginfoList || loginfoList.size() == 0) {
			return null;
		} else {
			return loginfoList.get(0);
		}
	}
	

	
}
