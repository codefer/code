package cn.indexter.gdky.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.indexter.gdky.domain.User;
import cn.indexter.gdky.service.UserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Resource(name="userService")
	private UserService userService;
	
	
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public String getAllUser(){
		Collection<User> userList = this.userService.getAllEntity();
		return "listAction";
	}
	

	
	public String checkUsername(){
		int a = 1/0;
		User user = this.userService.getUserByName(this.getModel().getNickName());
		if(user==null){
			this.message = "该用户名可以使用";
		}else{
			this.message = "该用户名已经存在";
		}
		return "success";
	}
}
