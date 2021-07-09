package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="JobSeekers")

public class JobSeeker {
	
	@Id
	@GeneratedValue
	@Column(name="UserId",nullable=false)
	private int UserId;
	@Column(name="Name",nullable=false)
	private String Name;
	@Column(name="Surname",nullable=false)
	private String Surname;
	@Column(name="IdentityNumber",nullable=false,unique=true)
	private String IdentityNumber;
	public JobSeeker(int userId, String name, String surname, String identityNumber) {
		super();
		UserId = userId;
		Name = name;
		Surname = surname;
		IdentityNumber = identityNumber;
	}
	public JobSeeker() {
		super();
	}
	
	
}
