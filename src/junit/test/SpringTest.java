package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.PersonService;

public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test public void instanceSpring(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService1 = (PersonService)ctx.getBean("personService");
		personService1.save();
		ctx.close();
	}

}
