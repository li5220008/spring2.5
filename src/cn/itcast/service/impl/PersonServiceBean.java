package cn.itcast.service.impl;

import cn.itcast.dao.PersonDao;
import cn.itcast.service.PersonService;

public class PersonServiceBean implements PersonService {
	private PersonDao personDao;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void save(){
		personDao.add();
	}
	
	
}
