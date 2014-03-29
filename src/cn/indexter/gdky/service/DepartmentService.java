package cn.indexter.gdky.service;

import java.util.List;

import cn.indexter.gdky.domain.Department;

public interface DepartmentService extends BaseService<Department> {
/*	public void saveDepartment(Department department);

	public void updateDeparment(Department department);

	public void deleteDepartmentByID(Serializable id,String deleteMode);

	public Collection<Department> getAllDepartment();

	public Department getDepartmentById(Serializable id);
	
	public void saveDepartment(Department department);

	public void deleteDepartmentById(int id);
	
	public void updateDepartment(Department department) ;	
	
	public Department getDepartment(Integer id) ;

	public List<Department> getAllDepartment() ;
	
	
	
	public List<Department> getDepartmentBySql(String sql);*/
	
	
	
	public List<Department> getAllDepartment();

	public Object findUnique(String string, Object[] objects);

	public void persistEntities(List<Department> department);
	
	
/*	//写操作
	public void saveDepartment(Department t);
	public void updateDepartment(Department t);
	public void saveOrUpdateDepartment(Department t);
	public void deleteDepartment(Department t);
	//按照hql批处理实体
	public void batchDepartmentByHQL(String hql,Object...objects);
	//执行原生的sql语句
	public void executeSQL(String sql,Object...objects);
	
	
	public Department getDepartment(Integer id);
	public Department loadDepartment(Integer id);
	public List<Department> findDepartmentByHQL(String hql,Object...objects);
	//单值检索(查询结果有且仅有一条记录)
	public Object uniqueResult(String hql,Object...objects);
	//按照sql查询
	public List<Department> findObjectBySQL(String sql,Object...objects);
	
	public Long getMaxId(String hql);*/
	
	
	
	
}
