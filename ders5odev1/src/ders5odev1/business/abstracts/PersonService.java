package ders5odev1.business.abstracts;

import ders5odev1.core.AuthorizationService;
import ders5odev1.entities.concretes.Person;

public interface PersonService {
	boolean checkIfReal(Person person);
	void add(Person person);
	void update(Person person);
	void delete(Person person);
	void login(String email, String password);
	void login(AuthorizationService authorizationService);
}
