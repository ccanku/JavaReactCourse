package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.Job_positionsService;
import kodlama.io.hrms.dataAccess.abstracts.Job_positionsDao;
import kodlama.io.hrms.entities.concretes.Job_positions;

@Service
public class Job_positionsManager implements Job_positionsService{
	
	private Job_positionsDao job_positionsDao;
	
	
	@Autowired
	public Job_positionsManager(Job_positionsDao job_positionsDao) {
		super();
		this.job_positionsDao = job_positionsDao;
	}



	@Override
	public List<Job_positions> getAll() {
		return this.job_positionsDao.findAll();
	}

}
