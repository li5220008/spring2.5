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
	
	public void init(){
		System.out.println("我被初始化了！");
	}
	
	public PersonServiceBean(){
		System.out.println("我被实例化了！");
	}
	
	public void distory(){
		System.out.println("对象被销毁了！");
	}
	
}
