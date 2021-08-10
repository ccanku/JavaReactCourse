package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Job_positions;

public interface Job_positionsDao extends JpaRepository<Job_positions,Integer>{

}
