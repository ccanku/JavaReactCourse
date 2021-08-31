package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvert;
public interface JobAdvertService {
	Result addJobAdvert(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> getAll(); 
	DataResult<List<JobAdvert>> getAllSortedByDate(); 
	DataResult<List<JobAdvert>> getByEmployerName(String employerName); 
	DataResult<List<JobAdvert>> getByEmployerId(int id); 
}
