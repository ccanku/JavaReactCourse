package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{

	
	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi.");
	}

	@Override
	public Result addEmployer(Employer employer) {
		if(employer.getEmail() == null || employer.getFirmName() == null || employer.getPassword() == null 
				|| employer.getPhoneNumber() == null || employer.getWebSite() == null) {
			return new ErrorResult("Tüm alanları doldurun.");
		}else if(!employerCheckService.checkEmailFormat(employer.getEmail())) {//Metod emailin formatı doğruysa true dönüyor.
			return new ErrorResult("Email formatı hatalı.");
		}else if(!employerCheckService.checkIfWebsiteAndEmailHasTheSameDomain(employer.getEmail(), employer.getWebSite())) {//Metod aynı domaine sahiplerse true dönüyor.
			return new ErrorResult("Web sitenin ve emailin domaini aynı değil.");
		}else if(employerCheckService.doesEmailExist(employer.getEmail())) {
			return new ErrorResult("Bu email kullanımda");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("İş veren eklendi.");
		}
		
	}
	
	public void verifyEmployer(Employer employer) {
		employer.setVerifiedByStaff(true);
	}
	
	public void unverifyEmployer(Employer employer) {
		employer.setVerifiedByStaff(false);
	}
	
}
