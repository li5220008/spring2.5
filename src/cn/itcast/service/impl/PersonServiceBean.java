package cn.itcast.service.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.itcast.dao.PersonDao;
import cn.itcast.service.PersonService;

@Service
public class PersonServiceBean implements PersonService {
	//@Autowired
	private PersonDao personDao;
	
	public PersonServiceBean(){}
	
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
