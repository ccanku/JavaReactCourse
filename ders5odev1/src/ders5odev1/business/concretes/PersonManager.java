package ders5odev1.business.concretes;

import java.util.List;

import ders5odev1.business.abstracts.EmailService;
import ders5odev1.business.abstracts.PersonService;
import ders5odev1.core.AuthorizationService;
import ders5odev1.dataAccess.abstracts.PersonDao;
import ders5odev1.entities.concretes.Person;

public class PersonManager implements PersonService{
	
	private EmailService emailService;
	private PersonDao personDao;
	private List<Person> personlist;
	
	public PersonManager(EmailService emailService, PersonDao personDao) {
		super();
		this.personDao = personDao;
		this.emailService = emailService;
	}

	

	@Override
	public boolean checkIfReal(Person person) {
		if(person.getFirstName().length() < 2 || person.getLastName().length() < 2 || 
				!emailService.checkEmailFormat(person.getEmail()) || emailService.checkIfEmailExist(person.getEmail())
						|| person.getPassword().length() < 6) {
			System.out.println("Temel bilgilerde hata");
			return false;
		}
		return true;
	}



	@Override
	public void add(Person person) {
		if(checkIfReal(person)) {
			System.out.println("Kullanıcı başarıyla eklendi.");
			this.personDao.add(person);
		}	
	}



	@Override
	public void update(Person person) {
		
	}



	@Override
	public void delete(Person person) {
		
	}

	@Override
	public void login(String email, String password) {
		for(Person person : personlist) {
			if(person.getEmail().contains(email) && person.getPassword().contains(password)) {
				System.out.println("Giriş başarılı");
			}
		}
		System.out.println("Giriş başarısız");
	}

	@Override
	public void login(AuthorizationService authorizationService) {
		authorizationService.giveAuthorization();
		System.out.println("Giriş başarılı");
	}

	public List<Person> getPersonlist() {
		return personlist;
	}
	
	public void setPersonlist(List<Person> personlist) {
		this.personlist = personlist;
	}

}
