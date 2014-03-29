package cn.indexter.gdky.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.indexter.gdky.dao.BaseDao;
import cn.indexter.gdky.service.BaseService;
import cn.indexter.gdky.utils.GenericsUtils;

/**
 * �����serviceʵ��,ר�����ڼ̳�
 */
public  class BaseServiceImpl<T> implements BaseService<T> {
	
	private BaseDao<T> dao ;
	
	private Class<T> clazz ;
	
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
	/*	ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];*/
		
		clazz=GenericsUtils.getSuperClassGenricType(this.getClass(),0);
	}

	//注入dao
	//@Resource
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	@Override
	public void saveEntity(T t) {
		// TODO Auto-generated method stub
		this.dao.deleteEntity(t);
		
	}

	@Override
	public void updateEntity(T t) {
		// TODO Auto-generated method stub
		this.dao.updateEntity(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		// TODO Auto-generated method stub
		this.dao.saveOrUpdateEntity(t);
		
	}

	@Override
	public void deleteEntity(T t) {
		// TODO Auto-generated method stub
		this.dao.deleteEntity(t);
	}

	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		// TODO Auto-generated method stub
		this.dao.batchEntityByHQL(hql, objects);
		
	}

	@Override
	public void executeSQL(String sql, Object... objects) {
		// TODO Auto-generated method stub
		this.dao.executeSQL(sql, objects);
		
		
	}

	@Override
	public T getEntity(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.getEntity(id);
	}

	@Override
	public T loadEntity(Integer id) {
		// TODO Auto-generated method stub
		return this.dao.loadEntity(id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects) {
		// TODO Auto-generated method stub
		return this.dao.findEntityByHQL(hql, objects);
	}

	@Override
	public Object uniqueResult(String hql, Object... objects) {
		// TODO Auto-generated method stub
		return this.dao.uniqueResult(hql, objects);
	}

	@Override
	public List<T> findObjectBySQL(String sql, Object... objects) {
		// TODO Auto-generated method stub
		return this.dao.findObjectBySQL(sql, objects);
	}

	@Override
	public Long getMaxId(String hql) {
		// TODO Auto-generated method stub
		return this.dao.getMaxId(hql);
	}
	
	public List<T> getAllEntity(){
		return this.dao.getAllEntity();
	}


	
//
//	public void saveEntity(T t) {
//		dao.saveEntity(t);		
//	}
//
//	public void updateEntity(T t) {
//		dao.updateEntity(t);
//	}
//
//	public void deleteEntityById(int id) {
//		dao.deleteEntityById(id);
//	}
//
//	public T getEntity(Integer id) {
//		return dao.getEntity(id);
//	}
//
//	public List<T> getAllEntity() {
//		return dao.getAllEntity();
//	}
//	
	
	
/*
	public void saveEntity(T t) {
		dao.saveEntity(t);
	}

	public void deleteEntity(int id) {
		dao.deleteEntityById(id);
	}

	public void updateEntity(T t) {
		dao.updateEntity(t);
	}
	
	public T getEntityById(int id){
		return dao.getEntity(id);
	}
	
	public List<T> getAllEntity(){
		return (List<T>)dao.getAllEntity();
	}*/
	
}
