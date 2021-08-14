package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job_positions")
public class JobsController {
	
	private JobPositionService job_positionsService;

	@Autowired
	public JobsController(JobPositionService job_positionsService) {
		super();
		this.job_positionsService = job_positionsService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.job_positionsService.getAll();
	}
	
	@PostMapping("/add")
	public Result addJobPosition(@RequestBody JobPosition jobPosition) {
		return this.job_positionsService.addJobPosition(jobPosition);
	}
}
