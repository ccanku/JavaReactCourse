package kodlama.io.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.abstracts.User;

@Service
public class EmployerCheckManager implements EmployerCheckService{
	private UserDao userDao;
	
	@Autowired
	public EmployerCheckManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean doesEmailExist(String email) {
		for(User user : userDao.findAll()) {
			if(user.getEmail().contains(email)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkIfWebsiteAndEmailHasTheSameDomain(String email, String website) {
		int index = email.indexOf("@");
		String emailDomain = email.substring(index);
		String websiteDomain = website.replaceFirst("^(https?://)?(www\\.)?", "");
		if(emailDomain.contains(websiteDomain)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean checkEmailFormat(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	
}
