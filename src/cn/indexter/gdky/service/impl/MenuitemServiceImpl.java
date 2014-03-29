package cn.indexter.gdky.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.indexter.gdky.dao.MenuitemDao;
import cn.indexter.gdky.domain.Menuitem;
import cn.indexter.gdky.domain.User;
import cn.indexter.gdky.service.MenuitemService;
import cn.indexter.gdky.service.UserService;





public class MenuitemServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService{

	//@Resource(name="menuitemDao")
	
	private MenuitemDao menuitemDao;
	
	
	
	public MenuitemDao getMenuitemDao() {
		return menuitemDao;
	}

	public void setMenuitemDao(MenuitemDao menuitemDao) {
		this.menuitemDao = menuitemDao;
		super.setDao(menuitemDao);
	}


	
	private UserService userService;
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Collection<Menuitem> getMenuitemsByPid(Long pid) {
		// TODO Auto-generated method stub
		String  hql="from Menuitem where pid=?";
		Menuitem menuitem=new Menuitem();
		menuitem.setChecked(true);
		menuitem.setMid(-1L);
		menuitem.setIsParent(true);
		menuitem.setIcon("css/images/MenuIcon/FUNC20082.gif");
		/*menuitem.setName(((User)ServletActionContext.getContext().getSession().get("user")).getNickName());*/
		Collection<Menuitem> menuitems=new HashSet<Menuitem>();
		menuitems.add(menuitem);
		return menuitems;
		//return this.hibernateTemplate.find("from Menuitem where pid=?",pid);
		//return this.findEntityByHQL(hql, pid);
	}

	public Set<Menuitem> getMenuitemsByIDS(Long[] ids) {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from Menuitem");
		stringBuffer.append(" where mid in(");
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1){
				stringBuffer.append(ids[i]+",");
			}else{
				stringBuffer.append(ids[i]);
			}
		}
		stringBuffer.append(")");
		List<Menuitem> menuitemList=this.findEntityByHQL(stringBuffer.toString());
//		List<Menuitem> menuitemList = this.hibernateTemplate.find(stringBuffer.toString());
		return new HashSet<Menuitem>(menuitemList);
	}
//
	public Collection<Menuitem> getMenuitemsByUser() {
		// TODO Auto-generated method stub
		/*User user = userService.getEntity(((User)ServletActionContext.getContext().getSession().get("user")).getId());*/
		
		 User user=userService.getEntity(1);

		
		if(user.isSuperAdmin()){
			return this.findEntityByHQL("from Menuitem ");
			//return null;
		}else{
			
			return this.findEntityByHQL("from Menuitem m inner join fetch m.users u where u.id=?",user.getId());
		}
	}

	public Collection<Menuitem> getAllMenuitems() {
		return this.getAllEntity();
	}

		

}
