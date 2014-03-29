package cn.indexter.gdky.service.impl;

import java.util.List;

import cn.indexter.gdky.dao.BaseDao;
import cn.indexter.gdky.dao.DepartmentDao;
import cn.indexter.gdky.domain.Department;
import cn.indexter.gdky.service.DepartmentService;

public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
		this.setDao(departmentDao);
	}

	
	
	public void setDao(BaseDao<Department> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> getAllDepartment() {
	        return 	departmentDao.getAllDepartment();
	}

	@Override
	public Object findUnique(String string, Object[] objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistEntities(List<Department> department) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	/*public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.saveEntity(department);
		//this.saveEntity(department);
	}

	public void updateDeparment(Department department) {
		// TODO Auto-generated method stub
		this.updateDeparment(department);
		//this.departmentDao.updateDeparment(department);
	}

	public void deleteDepartmentByID(Serializable id,String deleteMode) {
		// TODO Auto-generated method stub
		//this.departmentDao.deleteEntityById((Integer) id);
		this.departmentDao.deleteDepartmentByID(id,deleteMode);
	}

	public Collection<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		//int a = 1/0;
		//this.departmentDao.getAllEntity();
		return this.departmentDao.getAllEntity();
	}

	public Department getDepartmentById(Serializable id) {
		// TODO Auto-generated method stub
		//return this.getEntity((Integer) id);
		return this.departmentDao.getDepartmentById(id);
	}
	*/
}
