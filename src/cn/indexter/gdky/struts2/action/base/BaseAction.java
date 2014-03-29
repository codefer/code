package cn.indexter.gdky.struts2.action.base;

import java.lang.reflect.ParameterizedType;

/**
 * 这里封装一些共用的内容
 * @author Administrator
 *
 */
public class BaseAction<T>{
	private String message;//处理ajax产生的异常
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	private Class classt;
	private T t;
	public BaseAction(){
		try{
			ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
			this.classt = (Class)type.getActualTypeArguments()[0];
			this.t = (T)this.classt.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static final String LISTACTION = "listAction";  
	public static final String ADDUI = "addUI";
	public static final String UPDATEUI = "updateUI";
	public static final String ACTION2ACTION = "action2action";
	public String listAction = LISTACTION;
	public String updateUI = UPDATEUI;
	public String addUI = ADDUI;
	public String action2action = ACTION2ACTION;
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}
}
