package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.io.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="userid")
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends User{
	
	@Column(name="name")
	private String firstName;
	@Column(name="surname")
	private String lastName;
	@Column(name="nationalid")
	private String nationalId;
	@Column(name="yearofbirth")
	private String yearOfBirth;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	
	
	
}
