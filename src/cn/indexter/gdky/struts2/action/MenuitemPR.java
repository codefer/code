package cn.indexter.gdky.struts2.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.indexter.gdky.domain.Menuitem;
import cn.indexter.gdky.service.MenuitemService;

import com.bstek.dorado.annotation.DataProvider;


@Component
@Transactional 
public class MenuitemPR  extends BaseAction<Menuitem>{

	private MenuitemService menuitemService;
	
	
	
	
	public MenuitemService getMenuitemService() {
		return menuitemService;
	}


	public void setMenuitemService(MenuitemService menuitemService) {
		this.menuitemService = menuitemService;
	}


	private Collection<Menuitem> menuitemList;
	
	
	public Collection<Menuitem> getMenuitemList() {
		return menuitemList;
	}

	
	@DataProvider
	public List<Menuitem> getAllMenuitem(){
		return menuitemService.getAllEntity();
	}
	
}
