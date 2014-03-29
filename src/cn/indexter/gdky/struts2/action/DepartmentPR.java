package cn.indexter.gdky.struts2.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.indexter.gdky.domain.Department;
import cn.indexter.gdky.service.DepartmentService;
import cn.indexter.gdky.struts2.action.base.BaseAction;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.oracle.jrockit.jfr.Producer;



public class DepartmentPR extends BaseAction<Department>{


	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public String getAllDepartment(){
		try{
			Collection<Department> departmentList = this.departmentService.getAllDepartment();
			for(Department d:departmentList){
				System.out.println(d.getDname());
			}
		}catch(Exception e){
			e.printStackTrace();
			/**
			 * 
			 */
			/*this.setMessage(ActionContext.getContext().getValueStack().peek().toString());*/
		}
		return "success";
	}
	
/*	@DataProvider
	public void getDepartment(Page<Department> page, Criteria criteria)
			throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Department.class);
		if (criteria != null) {
			HibernateUtils.createFilter(detachedCriteria, criteria);
		}
		producerDao.find(page, detachedCriteria
				.getExecutableCriteria(producerDao.getSession()));
	}*/
	
	@DataProvider
	public List<Department> getAllDepartment1(){
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		List list=new ArrayList(departmentList);
		for(Department d:departmentList){
			System.out.println(d.getDname());
		}
		return list;
	}

	@Expose
	public String validatorCompanyName(String name) {
		if (StringUtils.hasText(name)) {
			if (departmentService.findUnique("from Producer where companyName=?",
					new Object[] { name }) != null) {
				return "��Ӧ������ظ�!";
			}
		}
		return null;
	}
	
	@DataResolver
	@Transactional
	public void saveAll(List<Department> department) {
		departmentService.persistEntities(department);
	}
}
