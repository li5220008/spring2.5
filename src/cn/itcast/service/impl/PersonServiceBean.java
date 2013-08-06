package cn.itcast.service.impl;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import cn.itcast.dao.PersonDao;
import cn.itcast.service.PersonService;

@Service("personService") 
@Scope("prototype")
public class PersonServiceBean implements PersonService {
	//@Autowired
	private PersonDao personDao;
	
	public PersonServiceBean(){}
	@PostConstruct
	public void init(){
		System.out.println("初始化方法！");
	}
	
	@PreDestroy
	public void distroy(){
		System.out.println("销毁关闭资源。");
	}
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}
	

	@Override
	public void save(){
		personDao.add();
	}
	
	
}
