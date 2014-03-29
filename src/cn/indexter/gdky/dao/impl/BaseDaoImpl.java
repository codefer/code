package cn.indexter.gdky.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.indexter.gdky.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	private SessionFactory sessionFactory ;
	

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	private Class<T> clazz ;
	
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
		
	}
	
	

/*	@Override
	public List<T> getAllEntity() {
		sf.getCurrentSession().g
	}
*/

	public void saveEntity(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void updateEntity(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public void saveOrUpdateEntity(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	public void deleteEntity(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public void batchEntityByHQL(String hql, Object... objects) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}
	
	//ִ��ԭ���sql���
	public void executeSQL(String sql,Object...objects){
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}

	//get
	@SuppressWarnings("unchecked")
	public T getEntity(Integer id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	//load
	public T loadEntity(Integer id) {
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}
	
	public List<T> findEntityByHQL(String hql, Object... objects) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
	
	//��ֵ����(��ѯ������ҽ���һ����¼)
	public Object uniqueResult(String hql,Object...objects){
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}
	
	//����sql��ѯ
	public List<T> findObjectBySQL(String sql,Object...objects){
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		//���ʵ����,��sql��ѯ�ļ�����,������������װ��ʵ�����
		q.addEntity(clazz);
		return q.list();
	}
	public Long getMaxId(String hql) {
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//System.out.println(query.list().get(0).toString());
		Long maxId=Long.parseLong(query.list().get(0).toString());
		System.out.println(maxId);
		return maxId;
	}
	
	public List<T> getAllEntity(){
		Query q = sessionFactory.getCurrentSession().createQuery("from "+clazz.getSimpleName());
		return q.list();
	/*	for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}*/
	/*	return q.uniqueResult();
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery("select * from "+"users");
		q.addEntity(clazz);
		return q.list();*/
	}





	
	
/*	private Class classt;
	*//**
	 * 1、在父类中要执行一段代码，这个代码的执行时间为子类创建对象的时候，这段代码已经执行完了，根据这个需求，有两种方案供选择
	 *      *  利用static语句块
	 *      *  利用父类的构造函数
	 * 2、分析：
	 *      因为得到ParameterizedType需要用到this关键字，而this关键字不能出现在static语句块中
	 *    所以只能选择父类的构造器
	 *//*
	public BaseDaoImpl(){
		*//**
		 * ParameterizedType就是泛型
		 *//*
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.classt = (Class)type.getActualTypeArguments()[0];//<T>
		System.out.println(type.getRawType());
	}
	*/
	
	
	
	
	
	
	
/*	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/

/*	public Collection<T> getAllEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from "+this.classt.getName());
	}

	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		return (T)this.hibernateTemplate.get(this.classt, id);
	}

	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
	}

	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		T t = this.getEntryById(id);
		this.hibernateTemplate.delete(t);
	}*/

/*	@Override
	public void saveEntity(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	@Override
	public void deleteEntityById(int id) {
		// TODO Auto-generated method stub
		T t = this.getEntity(id);
		this.hibernateTemplate.delete(t);
	}

	@Override
	public void updateEntity(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
		
	}

	@Override
	public T getEntity(Integer id) {
		// TODO Auto-generated method stub
		return (T)this.hibernateTemplate.get(this.classt, id);
	}

	@Override
	public List<T> getAllEntity() {
		return this.hibernateTemplate.find("from "+this.classt.getName());

	}

	@Override
	public List<T> getEntityBySql(String sql) {
		// TODO Auto-generated method stub
		return null;
	}*/

  

}
