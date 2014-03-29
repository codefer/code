package cn.indexter.gdky.struts2.action;

import java.util.Collection;

import org.springframework.beans.BeanUtils;

import cn.indexter.gdky.domain.Department;
import cn.indexter.gdky.service.DepartmentService;
import cn.indexter.gdky.struts2.action.base.BaseAction;



public class DepartmentAction extends BaseAction<Department>{


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
			/**
			 * 
			 */
			/*this.setMessage(ActionContext.getContext().getValueStack().peek().toString());*/
		}
		return "success";
	}
	
	public String deleteDepartment(){
		this.departmentService.deleteEntity(this.getModel());
		return action2action;
	}
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		/**
		 * 1、新建一个department
		 * 2、把模型驱动中的值赋值到department中
		 * 3、执行save方法保存
		 */
		Department department = new Department();
		/**
		 * 对象的属性的赋值的过程
		 */
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveEntity(department);
		return action2action;
	}
	/**
	 * 一般情况下，如果数据进行回显，则把数据放入到对象栈中，页面上可以根据name属性的值进行回显
	 * 如果把数据放入到了map栈，则页面根据value的值进行回显，而且value="%{ognl表达式}"
	 * @return
	 */
	public String updateUI(){
		Department department = this.departmentService.getEntity((this.getModel().getDid()).intValue());
		/*ActionContext.getContext().getValueStack().getRoot().add(0,department);*/
		//BeanUtils.copyProperties(department, this.getModel());
		//ActionContext.getContext().put("department", department);
		return updateUI;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		/**
		 * 1、先根据id把该数据从数据库中提取出来(或者从session的缓存中)
		 * 2、把修改以后的数据赋值到该对象中
		 * 3、针对该对象进行update操作
		 */
		Department department = this.departmentService.getEntity((this.getModel().getDid()).intValue());
		BeanUtils.copyProperties(this.getModel(),department);
		this.departmentService.updateEntity(department);
		return action2action;
	}
}
