package cn.indexter.gdky.dao;

import java.util.List;

import cn.indexter.gdky.dao.impl.BaseDaoImpl;
import cn.indexter.gdky.domain.Department;

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao<Department>{

/*	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.saveEntity(department);
	//	this.saveEntry(department);
	}

	public void updateDeparment(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}

	public void deleteDepartmentByID(Serializable id,String deleteMode) {
		Department department = this.getDepartmentById(id);
		if("del".equals(deleteMode)){//单表的删除
			this.getHibernateTemplate().delete(department);
		}else if("del_pre_release".equals(deleteMode)){//删除之前先解除关系
			Set<User> users = department.getUsers();
			for(User user:users){
				//user.setDepartment(null);
			}
		}else{//级联删除
			
		}
		this.getHibernateTemplate().delete(department);
	}

	public Collection<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Department");
	}

	public Department getDepartmentById(Serializable id) {
		// TODO Auto-generated method stub
		return (Department)this.getHibernateTemplate().get(Department.class, id);
	}
*/
	
	public List<Department> getAllDepartment(){
		
		return this.findObjectBySQL("select * from department");
		
	}
	
}
