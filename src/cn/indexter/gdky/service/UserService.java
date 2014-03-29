package cn.indexter.gdky.service;

import java.util.List;

import cn.indexter.gdky.domain.User;

public interface UserService extends BaseService<User> {


	public boolean isRegisted(String email);


	public User validateLoginInfo(String email, String md5);


	public void updateAuthorize(User model, Integer[] ownRoleIds);


	public void clearAuthorize(Integer userId);
	
	public User getUserByName(String nickName);


	//public List<User> getAllEntity();
	
	
}
