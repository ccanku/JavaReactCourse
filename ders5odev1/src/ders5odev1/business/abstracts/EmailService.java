package ders5odev1.business.abstracts;


import ders5odev1.entities.concretes.Person;

public interface EmailService {
	boolean checkEmailFormat(String email);
	boolean checkIfEmailExist(String email);
	void sendVerificationEmail(Person person, String email);
	void verified(Person person, String verificationCode);
	
}
