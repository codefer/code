package cn.itcast.oa0909.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BaseSpring {
	public static ApplicationContext context;
	@Before
	public void startSpring(){
		/*context = new ClassPathXmlApplicationContext("classpath:dorado-home/app-context.xml");*/
		 context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/dorado-home/app-context.xml");  
	}
}
