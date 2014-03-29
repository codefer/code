package cn.indexter.gdky.service;


import java.util.Collection;
import java.util.Set;

import cn.indexter.gdky.domain.Menuitem;

public interface MenuitemService extends BaseService<Menuitem>{

   public Collection getMenuitemsByPid(Long pid);
	
	public Set getMenuitemsByIDS(Long[] ids);
	
	public Collection getMenuitemsByUser();
	
	public  Collection getAllMenuitems();
}
