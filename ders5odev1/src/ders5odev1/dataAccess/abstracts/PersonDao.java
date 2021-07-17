package ders5odev1.dataAccess.abstracts;

import java.util.List;

import ders5odev1.entities.concretes.Person;

public interface PersonDao {
	
	void add(Person product);
	void update(Person product);
	void delete(Person product);
	Person get(int id);
	List<Person> getAll();
}
