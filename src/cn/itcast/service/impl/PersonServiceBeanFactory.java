package cn.itcast.service.impl;

public class PersonServiceBeanFactory {
	public static PersonServiceBean createPersonServiceBean(){
		return new PersonServiceBean();
	}
}
