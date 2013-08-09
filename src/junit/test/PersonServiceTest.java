package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bean.Person;
import cn.itcast.service.PersonService;

public class PersonServiceTest {
	private static PersonService personService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
			personService = (PersonService)ctx.getBean("personService");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void save(){
		personService.save(new Person("传智播客"));
	}

}
