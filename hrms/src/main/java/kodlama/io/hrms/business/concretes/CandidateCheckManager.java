package kodlama.io.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateCheckService;
import kodlama.io.hrms.core.utilities.validations.abstracts.IdentityVerificationService;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.abstracts.User;
import kodlama.io.hrms.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{
	private UserDao userdao;
	private CandidateDao candidateDao;
	private IdentityVerificationService identityVerificationService;
	
	@Autowired
	public CandidateCheckManager(UserDao userdao, CandidateDao candidateDao,
			IdentityVerificationService identityVerificationService) {
		super();
		this.userdao = userdao;
		this.candidateDao = candidateDao;
		this.identityVerificationService = identityVerificationService;
	}
	

	@Override
	public boolean isNotRealPerson(Candidate candidate) {
		return !identityVerificationService.CheckIfRealPerson(candidate);
	}



	@Override
	public boolean doesEmailExist(String email) {
		for(User user : userdao.findAll()) {
			if(user.getEmail().contains(email)) return true;
		}
		return false;
	}

	@Override
	public boolean doesNationalIdExist(String nationalId) {
		for(Candidate candidate : candidateDao.findAll()) {
			if(candidate.getNationalId().contains(nationalId)) return true;
		}
		return false;
	}


	@Override
	public boolean checkEmailFormat(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	
}
