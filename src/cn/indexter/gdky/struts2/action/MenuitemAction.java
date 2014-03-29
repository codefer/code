package cn.indexter.gdky.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.indexter.gdky.domain.Menuitem;
import cn.indexter.gdky.service.MenuitemService;



@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction  extends BaseAction<Menuitem>{

	@Resource(name="menuitemService")
	private MenuitemService menuitemService;
	
	private Collection<Menuitem> menuitemList;
	
	
	public Collection<Menuitem> getMenuitemList() {
		return menuitemList;
	}



	public String getALLMenuitem(){
		Collection<Menuitem> menuitemList=this.menuitemService.getAllMenuitems();
		//this.menuitemService.geta
		return "success";
	}
	
	
	public String showMenuitemsByPid(){
		this.menuitemList=this.menuitemService.getMenuitemsByPid(this.getModel().getPid());
		return "success";
	}
	
	public String showMenuitemsByUser(){
		this.menuitemList = this.menuitemService.getMenuitemsByUser();
		return "success";
	}
	
}
