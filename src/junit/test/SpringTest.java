package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.PersonService;

public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test public void instanceSpring(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//ItcastClassPathXMLApplicationContext ctx = new ItcastClassPathXMLApplicationContext("beans.xml");
		PersonService personService1 = (PersonService)ctx.getBean("personService");
		PersonService personService2 = (PersonService)ctx.getBean("personService");
		System.out.println(personService1.equals(personService2));
		personService1.save();
		//ctx.close();
	}

}
