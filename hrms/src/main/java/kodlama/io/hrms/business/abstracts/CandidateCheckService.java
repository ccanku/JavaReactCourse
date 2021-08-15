package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean isNotRealPerson(Candidate candidate);
	boolean doesEmailExist(String email);
	boolean doesNationalIdExist(String nationalId);
	boolean checkEmailFormat(String email);
}
