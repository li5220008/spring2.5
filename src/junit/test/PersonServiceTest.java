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
		try{
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			personService = (PersonService)cxt.getBean("personService");
		}catch(RuntimeException e){
			e.printStackTrace();
		}
	}
	
	@Test public void save(){
		personService.save(new Person("传智播客11"));
	}
	
	@Test public void getPerson(){
		Person person = personService.getPerson(1);
		System.out.println(person.getName());
	}
	
	@Test public void update(){
		Person person = personService.getPerson(1);
		person.setName("张XX");
		personService.update(person);
	}
	 
	@Test public void delete(){
		try {
			personService.delete(7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test public void getBeans(){
		for (Person person : personService.getPersons()){
			System.out.println(person.getName());
		}
	}

}
