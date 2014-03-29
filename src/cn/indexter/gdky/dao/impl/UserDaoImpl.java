package cn.indexter.gdky.dao.impl;

import java.io.Serializable;
import java.util.Collection;

import cn.indexter.gdky.dao.UserDao;
import cn.indexter.gdky.domain.User;


public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao<User> {

/*	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.saveEntry(user);
	}*/

	public void updateDeparment(User user) {
		// TODO Auto-generated method stub
		this.updateEntity(user);
	}

/*	public void deleteUserByID(Serializable id,String deleteMode) {
		User User = this.getUserById(id);
		if("del".equals(deleteMode)){//单表的删除
			this.getHibernateTemplate().delete(User);
		}else if("del_pre_release".equals(deleteMode)){//删除之前先解除关系
			Set<User> users = User.getUsers();
			for(User user:users){
				//user.setUser(null);
			}
		}else{//级联删除
			
		}
		this.getHibernateTemplate().delete(User);
	}*/

/*	public Collection<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.findObjectBySQL("select * from user");
	}

	public User getUserById(Serializable id) {
		// TODO Auto-generated method stub
		return (User)this.getEntity((Integer) id);
	}

	public void saveEntry(User t) {
		// TODO Auto-generated method stub
		
	}

	public void updateEntry(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserByID(Serializable id, String deleteMode) {
		// TODO Auto-generated method stub
		
	}*/

}
