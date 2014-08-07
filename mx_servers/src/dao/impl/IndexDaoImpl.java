package dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

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
	
}
