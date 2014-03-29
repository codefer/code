package cn.itcast.oa0909.test;

import java.util.Collection;
import java.util.List;

import org.junit.Test;


import cn.indexter.gdky.domain.User;
import cn.indexter.gdky.service.UserService;
import cn.indexter.gdky.utils.DataUtil;

public class UserTest extends BaseSpring{
	@Test
	public void testQuery(){
		UserService UserService = (UserService)context.getBean("userService");
		System.out.println(UserService);
		//User user = UserService.getEntity(1);
		//System.out.println(user);
		//System.out.println(user.getNickName());
		List<User> UserList=UserService.getAllEntity();
		for(User user2:UserList)
		{
			System.out.println(user2.getNickName());
		}
		/*User user = UserService.getUserByName("jdkobe");
		System.out.println(user);*/
	}
	
	@Test
	public void testQuery2(){
		UserService UserService = (UserService)context.getBean("userService");
		System.out.println(UserService);
		User user=UserService.getEntity(1);
		System.out.println(user.getEmail());
		
		//User user = UserService.getEntity(1);
		//System.out.println(user);
		//System.out.println(user.getNickName());
		//User user=UserService.validateLoginInfo("343731621@qq.com", "123456");
		//System.out.println(user.getEmail());
		/*User user = UserService.getUserByName("jdkobe");
		System.out.println(user);*/
	}
}
