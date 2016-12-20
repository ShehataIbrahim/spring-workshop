package com.ih.spring.components.orm;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
//@EnableTransactionManagement
public class SecurityUserService implements SecurityUserDao{
	private static final Logger logger=Logger.getLogger(SecurityUserService.class.getName());
	 @Autowired
	 private SessionFactory sessionFactory;
//	 @Autowired
//	 TransactionTemplate template;
//	 
	 @Transactional
	@Override
	public SecurityUser findUser(final String name) {
//		 return this.template.execute(new TransactionCallback<SecurityUser>() {
//			 @Override
//			public SecurityUser doInTransaction(TransactionStatus arg0) {
		 logger.info("********************"+name);
		 logger.info("********************"+sessionFactory);
		 
				Query<SecurityUser> q= sessionFactory.getCurrentSession().createQuery("from SecurityUser where name="+name);
					List<SecurityUser> result=q.getResultList();
					return result.size()>0?result.get(0):null;
//			}
//		});
		
	}

	@Transactional
	@Override
	public void update(SecurityUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String name) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	@Override
	public Collection<SecurityUser> findUsers() {
/*return this.template.execute(new TransactionCallback<List>() {
			
			@Override
			public List<SecurityUser> doInTransaction(TransactionStatus arg0) {*/
				Query<SecurityUser> q= sessionFactory.getCurrentSession().createQuery("from SecurityUser");
				return q.getResultList();
			//}
		//});
		
	}

}
