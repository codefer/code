package cn.indexter.gdky.dao;

import java.util.List;

import cn.indexter.gdky.domain.Menuitem;

public interface MenuitemDao<T> extends BaseDao<T>{
	
	
	public List<Menuitem> getAllMenuitem();
/*	public void saveDepartment(Department department);
	
	public void updateDeparment(Department department);
	
	public void deleteDepartmentByID(Serializable id,String deleteMode);
	
	public Collection<Department> getAllDepartment();
	
	public Department getDepartmentById(Serializable id);*/
}
