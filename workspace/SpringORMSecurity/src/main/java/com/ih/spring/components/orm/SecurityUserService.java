package com.ih.spring.components.orm;

import java.util.Collection;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SecurityUserService implements SecurityUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SecurityUser findUser(final String name) {
		sessionFactory.getCurrentSession().beginTransaction();
		Query<SecurityUser> q = sessionFactory.getCurrentSession().createQuery("from SecurityUser where name=:name").setParameter("name", name);
		List<SecurityUser> result = q.getResultList();
		sessionFactory.getCurrentSession().getTransaction().commit();
		return result.size() > 0 ? result.get(0) : null;
	}
	
	@Override
	public void update(SecurityUser user) {
		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(user);
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void deleteUser(String name) {
		sessionFactory.getCurrentSession().beginTransaction();
		Query<SecurityUser> q = sessionFactory.getCurrentSession().createQuery("from SecurityUser where name=:name").setParameter("name", name);
		List<SecurityUser> result = q.getResultList();
		SecurityUser user=result.size() > 0 ? result.get(0) : null;
		if(user!=null)
			sessionFactory.getCurrentSession().delete(user);
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	@Override
	public Collection<SecurityUser> findUsers() {
		sessionFactory.getCurrentSession().beginTransaction();
		Query<SecurityUser> q = sessionFactory.getCurrentSession().createQuery("from SecurityUser");
		List<SecurityUser> result= q.getResultList();
		sessionFactory.getCurrentSession().getTransaction().commit();
		return result;
	}

}
