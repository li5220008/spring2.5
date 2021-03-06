package cn.itcast.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Person;
import cn.itcast.service.PersonService;

@Transactional
public class PersonServiceBean implements PersonService {
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Person person) {
		jdbcTemplate.update("insert into person(name) values(?) ", new Object[]{person.getName()}, 
				new int[]{java.sql.Types.VARCHAR});
	}

	@Override
	public void update(Person person) {
		jdbcTemplate.update("update person set name=? wherr id=?", new Object[]{person.getName(),
				person.getId()}, 
				new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});

	}

	@Override
	public Person getPerson(Integer personid) {
		Person person = (Person)jdbcTemplate.queryForObject("select * from person where id=?",  new Object[]{personid}, 
				new PersonRowMapper());
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		List<Person> persons = (List<Person>)jdbcTemplate.query("select * from person",new PersonRowMapper());
		return persons;
	}

	@Override
	public void delete(Integer personid) {
		jdbcTemplate.update("delete from person where id=?", new Object[]{personid}, 
				new int[]{java.sql.Types.INTEGER});
	}

}
