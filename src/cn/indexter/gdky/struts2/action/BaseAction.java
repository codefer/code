package cn.indexter.gdky.struts2.action;

import java.lang.reflect.ParameterizedType;

import cn.indexter.gdky.utils.GenericsUtils;

/**
 * �����action����,ר�����ڼ̳�
 */
public abstract class BaseAction<T> {

	private static final long serialVersionUID = -1314560516485837572L;
	
	public T model ;
	
	@SuppressWarnings("unchecked")
	public BaseAction(){
		try {
			/*ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];*/
			Class<T> clazz=GenericsUtils.getSuperClassGenricType(this.getClass(), 0);
			model = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void prepare() throws Exception {
	}

	public T getModel(){
		return model ;
	}
}
