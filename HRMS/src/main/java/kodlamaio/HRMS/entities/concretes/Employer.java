package kodlamaio.HRMS.entities.concretes;

import java.lang.annotation.Annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employers")
public class Employer {

	@Id
	@GeneratedValue
	@Column(name="UserId",nullable=false)
	private int UserId;
	@Column(name="CompanyName",nullable=false)
	private String CompanyName;
	@Column(name="Website",nullable=false)
	private String Website;
	@Column(name="PhoneNumber",nullable=false) 
	private String PhoneNumber;
	public Employer(int userId, String companyName, String website, String phoneNumber) {
		super();
		UserId = userId;
		CompanyName = companyName;
		Website = website;
		PhoneNumber = phoneNumber;
	}
	public Employer() {
		super();
	}
	
	
	
	
	
}
