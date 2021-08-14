package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.io.hrms.entities.abstracts.User;

@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="userid")
public class Candidate extends User{
	
	@Column(name="name")
	private String firstName;
	@Column(name="surname")
	private String lastName;
	@Column(name="nationalid")
	private String nationalId;
	@Column(name="yearofbirth")
	private String yearOfBirth;
	
	public Candidate() {}
	
	public Candidate(int id, String email, String password, String firstName, String lastName, String nationalId, String yearOfBirth) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.yearOfBirth = yearOfBirth;
	}

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
