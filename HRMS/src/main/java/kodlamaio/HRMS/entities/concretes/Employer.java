package kodlamaio.HRMS.entities.concretes;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers_table")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id",nullable=false)
	private int UserId;
	@Column(name="company_name",nullable=false)
	private String CompanyName;
	@Column(name="website",nullable=false)
	private String Website;
	@Column(name="email",nullable=false) 
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="password_again")
	private String passwordAgain;
	
	
	@OneToMany(mappedBy="employer")
	List<JobAdvertisement> jobAdvertisements;
	
	
	
	
}
