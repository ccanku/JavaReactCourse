package kodlama.io.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertDto {
	private int id;
	private int employerId;
	private String jobName;
	private String jobDescription;
	private String city;
	private int personnelInNeed;
	private Date deadlineDate;
	private int minWage;
	private int maxWage;
	
	
	public JobAdvertDto(int id,int employerId, String jobName, String jobDescription, String city, int personnelInNeed,
			Date deadlineDate) {
		super();
		this.id=id;
		this.employerId = employerId;
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.city = city;
		this.personnelInNeed = personnelInNeed;
		this.deadlineDate = deadlineDate;
	}
	
	
	
}
