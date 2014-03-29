package cn.itcast.oa0909.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.indexter.gdky.domain.Menuitem;
import cn.indexter.gdky.service.MenuitemService;

public class MenuitemTest extends BaseSpring{



	@Test
	public void testGetAllMenuitem(){
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");*/
		MenuitemService MenuitemService = (MenuitemService) context.getBean("menuitemService");
		
		System.out.println(MenuitemService);
		List<Menuitem> Menuitems=MenuitemService.getAllEntity();
		for(Menuitem Menuitem:Menuitems)
		{
			System.out.println(Menuitem.getName());
		}

		
	}
	
	@Test
	public void testGetMenuitemsByUser(){
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");*/
		MenuitemService MenuitemService = (MenuitemService) context.getBean("menuitemService");
		
		System.out.println(MenuitemService);
		List<Menuitem> Menuitems=(List<Menuitem>) MenuitemService.getMenuitemsByUser();
		
		for(Menuitem Menuitem:Menuitems)
		{
			System.out.println(Menuitem.getName());
		}

		
	}

}
