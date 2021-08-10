package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.Job_positionsService;
import kodlama.io.hrms.entities.concretes.Job_positions;

@RestController
@RequestMapping("/api/job_positions")
public class JobsController {
	
	private Job_positionsService job_positionsService;

	@Autowired
	public JobsController(Job_positionsService job_positionsService) {
		super();
		this.job_positionsService = job_positionsService;
	}
	
	@GetMapping("/getall")
	public List<Job_positions> getAll(){
		return this.job_positionsService.getAll();
	}
}
