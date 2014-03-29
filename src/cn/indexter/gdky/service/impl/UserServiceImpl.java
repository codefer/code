package cn.indexter.gdky.service.impl;

import java.util.List;

import cn.indexter.gdky.dao.UserDao;
import cn.indexter.gdky.domain.User;
import cn.indexter.gdky.service.UserService;
import cn.indexter.gdky.utils.ValidateUtil;

/**
 * UserServiceImpl
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	private UserDao userDao;



	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		super.setDao(userDao);
	}

	public boolean isRegisted(String email){
		String hql = "from User u where u.email = ?" ;
		List<User> list = this.findEntityByHQL(hql, email);
		return ValidateUtil.isValid(list);
	}
	
	public User validateLoginInfo(String email, String password){
		String hql = "from User u where u.email = ? and u.password = ?" ;
		List<User> list = this.findEntityByHQL(hql,email,password);
		if(list.size()==0)
		{
			String hql2 = "from User u where u.nickName=? and u.password = ?" ;
			List<User> list2 = this.findEntityByHQL(hql2,email,password);
			System.out.println(list2.get(0));
			return ValidateUtil.isValid(list2)?list2.get(0):null ;
		}
		
		return ValidateUtil.isValid(list)?list.get(0):null ;
	}
	

/*	public void updateAuthorize(User r, Integer[] ids){
		User uu = this.getEntity(r.getId());
		if(!ValidateUtil.isValid(ids)){
			uu.getRoles().clear();
		}
		else{
			String hql = "from Role r where r.id in ("+StringUtil.arr2Str(ids)+")" ;
			List<Role> roles  = roleService.findEntityByHQL(hql);
			uu.setRoles(new HashSet<Role>(roles));
		}
	}*/
	


	public void clearAuthorize(Integer userId){
		/*this.getEntity(userId).getRoles().clear();*/
	}

	public User getUserByName(String nickName) {
		// TODO Auto-generated method stub
		return (User)(this.findEntityByHQL("from User where nickname=?",nickName).get(0));
	//	return (User)this.findObjectBySQL("select * from users where nickname=?",nickName);
	}

	@Override
	public void updateAuthorize(User model, Integer[] ownRoleIds) {
		// TODO Auto-generated method stub
		
	}
}
