package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jobadverts")
public class JobAdvert {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="JobPositionName")
	private String jobPositionName;
	@Column(name="JobDescription")
	private String jobDescription;
	@Column(name="City")
	private String city;
	@Column(name="PersonnelInNeed")
	private int personnelInNeed;
	@Column(name="Deadline")
	private Date deadlineDate;
	@Column(name="MinWage")
	private int minWage;
	@Column(name="MaxWage")
	private int maxWage;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="EmployerId")
	private Employer employer;

	public JobAdvert(int id, String jobPositionName, String jobDescription, String city, int personnelInNeed,
			Date deadlineDate, Employer employer) {
		super();
		this.id = id;
		this.jobPositionName = jobPositionName;
		this.jobDescription = jobDescription;
		this.city = city;
		this.personnelInNeed = personnelInNeed;
		this.deadlineDate = deadlineDate;
		this.employer = employer;
	}
	
	
	
}
