package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao job_positionsDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao job_positionsDao) {
		super();
		this.job_positionsDao = job_positionsDao;
	}



	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.job_positionsDao.findAll(),"İş pozisyonları listelendi.");
	}



	@Override
	public Result addJobPosition(JobPosition jobPosition) {
		this.job_positionsDao.save(jobPosition);
		return new SuccessResult("Pozisyon eklendi.");
	}

}
