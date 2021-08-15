package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateCheckService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result addCandidate(Candidate candidate) {
		if(candidate.getEmail() == null || candidate.getFirstName() == null || candidate.getLastName() == null ||
				candidate.getNationalId() == null || candidate.getPassword() == null || candidate.getYearOfBirth() == null) {
			return new ErrorResult("Tüm alanları doldurun.");
		}else if(candidateCheckService.isNotRealPerson(candidate)) {
			return new ErrorResult("Böyle biri yok.");
		}else if(!candidateCheckService.checkEmailFormat(candidate.getEmail())) {//Metod emailin formatı doğruysa true dönüyor.
			return new ErrorResult("Email adresinizi kontrol ediniz.");
		}else if(candidateCheckService.doesEmailExist(candidate.getEmail())){
			return new ErrorResult("Bu email kullanımda.");
		}else if(candidateCheckService.doesNationalIdExist(candidate.getNationalId())) {
			return new ErrorResult("Bu kimlik numarası kullanılıyor.");
		}else {
			this.candidateDao.save(candidate);
			return new SuccessResult("İş arayan eklendi.");
		}
	}
	
	
	
}
