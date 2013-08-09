package cn.itcast.service;

import java.util.List;

import cn.itcast.bean.Person;

public interface PersonService {
	/**
	 * 
	 * @param person
	 */
	public void save(Person person);
	/**
	 * 
	 * @param person
	 */
	public void update(Person person);
	/**
	 * 
	 * @param personid
	 * @return
	 */
	public String getPerson(Integer personid);
	/**
	 * 
	 * @return
	 */
	public List<Person> getPersons();
	/**
	 * 
	 * @param personid
	 */
	public void delete(Integer personid);
}