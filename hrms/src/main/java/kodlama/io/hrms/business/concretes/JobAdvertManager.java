package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobAdvert;
import kodlama.io.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	private JobAdvertDao jobAdvertDao;
	private EmployerDao employerDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, EmployerDao employerDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"İş ilanları listelendi.");
	}

	@Override
	public  DataResult<List<JobAdvert>> getAllSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"deadlineDate");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),"İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployerName(String employerName) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_firmName(employerName),"İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_Id(id),"İş ilanları listelendi.");
	}

	@Override 
	public Result addJobAdvert(JobAdvertDto jobAdvertDto) {
		Employer employer = employerDao.getById(jobAdvertDto.getEmployerId());
		JobAdvert jobAdvert = new JobAdvert(jobAdvertDto.getId(),jobAdvertDto.getJobName(),jobAdvertDto.getJobDescription(),jobAdvertDto.getCity()
				,jobAdvertDto.getPersonnelInNeed(),jobAdvertDto.getDeadlineDate(),employer);
		if(jobAdvertDto.getMinWage() != 0 && jobAdvertDto.getMaxWage() != 0) {
			jobAdvert.setMinWage(jobAdvertDto.getMinWage());
			jobAdvert.setMaxWage(jobAdvertDto.getMaxWage());
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi.");
	}
	
}