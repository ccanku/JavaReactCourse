package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvert;
import kodlama.io.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertController {	
	
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/add")
	Result addJobAdvert(@RequestBody JobAdvertDto jobAdvertDto) {
		return this.jobAdvertService.addJobAdvert(jobAdvertDto);
	}
	
	@GetMapping("/getbyemployername")
	DataResult<List<JobAdvert>> getByEmployerName(@RequestParam String firmName){
		return this.jobAdvertService.getByEmployerName(firmName);
	}
	
	@GetMapping("/getbyemployerid")
	DataResult<List<JobAdvert>> getByEmployerId(@RequestParam int id){
		return this.jobAdvertService.getByEmployerId(id);
	}
	
	@GetMapping("/getallsortedbydate")
	DataResult<List<JobAdvert>> getAllSortedByDate(){
		return this.jobAdvertService.getAllSortedByDate();
	}
	@GetMapping("/getall")
	DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
}
