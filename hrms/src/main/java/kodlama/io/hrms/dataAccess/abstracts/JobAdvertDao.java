package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	List<JobAdvert> getByEmployer_firmName(String firmName);
	List<JobAdvert> getByEmployer_Id(int id);
}
