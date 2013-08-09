package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.PersonService;

public class SpringAOPTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test 
	public void interceptorTest(){
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService = (PersonService)cxt.getBean("personService");
		personService.setPersonName();
	}

}
