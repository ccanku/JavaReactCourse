package ders5odev1.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ders5odev1.business.abstracts.EmailService;
import ders5odev1.entities.concretes.Person;

public class EmailManager implements EmailService{

	private List<String> emails;
	@Override
	public boolean checkEmailFormat(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Override
	public boolean checkIfEmailExist(String email) {
		if(emails.contains(email)) {
			System.out.println("Bu email başka bir kullanıcı tarafından kullanılıyor.");
			return true;
		}
		return false;
	}
	public void sendVerificationEmail(Person person, String email) {
		System.out.println("Email gönderildi.");
	}
	
	public void verified(Person person, String verificationCode) {
		System.out.println("Email onaylandı.");
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
}


