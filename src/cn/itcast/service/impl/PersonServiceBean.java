package cn.itcast.service.impl;



import cn.itcast.service.PersonService;

public class PersonServiceBean implements PersonService {

	@Override
	public void save(String name) {
		System.out.println("我是save()方法");
		throw new RuntimeException("我爱例外");
	}

	@Override
	public void update(String name) {
		System.out.println("我是update()方法");
	}

	@Override
	public String setPersonName() {
		System.out.println("我是setPersonName()方法");
		return "xxxx";
	}
	
	
}
