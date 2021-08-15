package kodlama.io.hrms.business.abstracts;

public interface EmployerCheckService {
	boolean doesEmailExist(String email);
	boolean checkIfWebsiteAndEmailHasTheSameDomain(String email, String website);
	boolean checkEmailFormat(String email);
}
