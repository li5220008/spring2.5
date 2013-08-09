package cn.itcast.service.impl;

import java.util.List;

import javax.activation.DataSource;

import cn.itcast.bean.Person;
import cn.itcast.service.PersonService;

public class PersonServiceBean implements PersonService {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPerson(Integer personid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer personid) {
		// TODO Auto-generated method stub

	}

}
