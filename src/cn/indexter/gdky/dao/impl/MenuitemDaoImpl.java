package cn.indexter.gdky.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.indexter.gdky.dao.MenuitemDao;
import cn.indexter.gdky.domain.Menuitem;

@Repository("menuitemDao")
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao<Menuitem>{

	@Override
	public List<Menuitem> getAllMenuitem() {
		// TODO Auto-generated method stub
		return null;
	}



}
