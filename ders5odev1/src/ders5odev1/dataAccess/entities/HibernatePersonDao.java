package ders5odev1.dataAccess.entities;

import java.util.List;

import ders5odev1.dataAccess.abstracts.PersonDao;
import ders5odev1.entities.concretes.Person;

public class HibernatePersonDao implements PersonDao{

	@Override
	public void add(Person person) {
		 System.out.println("Kullanıcı hibernate kullanılarak eklendi: " + person.getId());
	}

	@Override
	public void update(Person person) {
		
	}

	@Override
	public void delete(Person person) {
		
	}

	@Override
	public Person get(int id) {
		
		return null;
	}

	@Override
	public List<Person> getAll() {
		
		return null;
	}

}
