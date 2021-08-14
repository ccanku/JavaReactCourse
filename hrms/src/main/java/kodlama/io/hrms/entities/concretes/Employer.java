package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.io.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="userid")
@AllArgsConstructor
public class Employer extends User{
	
	@Column(name="firmname")
	private String firmName;
	@Column(name="website")
	private String webSite;
	@Column(name="phonenumber")
	private String phoneNumber;
	
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
