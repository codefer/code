package cn.itcast.oa0909.test;

import java.util.List;

import org.junit.Test;

import cn.indexter.gdky.domain.Menuitem;
import cn.indexter.gdky.service.MenuitemService;
import cn.indexter.gdky.struts2.action.MenuitemPR;

public class MenuitemPRTest extends BaseSpring{



	@Test
	public void testGetAllMenuitem(){
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");*/
		MenuitemPR menuitemActionPR = (MenuitemPR) context.getBean("menuitemActionPR");
		
		System.out.println(menuitemActionPR);
		List<Menuitem> Menuitems=menuitemActionPR.getAllMenuitem();
		for(Menuitem Menuitem:Menuitems)
		{
			System.out.println(Menuitem.getName());
		}

		
	}
	


}
