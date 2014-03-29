package cn.indexter.gdky.dao;

import java.util.List;

public interface BaseDao<T>{
/*	public Collection<T> getAllEntry();
	public T getEntryById(Serializable id);
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntry(Serializable id);*/
	
/*	public void saveEntity(T t);

	public void deleteEntityById(int id);
	
	public void updateEntity(T t) ;	
	
	public T getEntity(Integer id) ;

	public List<T> getAllEntity() ;
	
	
	
	public List<T> getEntityBySql(String sql);
	*/
	
	public List<T> getAllEntity();
	
	//写操作
	public void saveEntity(T t);
	public void updateEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void deleteEntity(T t);
	//按照hql批处理实体
	public void batchEntityByHQL(String hql,Object...objects);
	//执行原生的sql语句
	public void executeSQL(String sql,Object...objects);
	
	public T getEntity(Integer id);
	public T loadEntity(Integer id);
	public List<T> findEntityByHQL(String hql,Object...objects);
	//单值检索(查询结果有且仅有一条记录)
	public Object uniqueResult(String hql,Object...objects);
	//按照sql查询
	public List<T> findObjectBySQL(String sql,Object...objects);
	
	public Long getMaxId(String hql);
}
