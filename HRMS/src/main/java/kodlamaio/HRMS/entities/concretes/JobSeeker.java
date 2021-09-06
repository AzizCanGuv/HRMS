package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers_table")
@AllArgsConstructor
@NoArgsConstructor


public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id",nullable=false)
	private int userId;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="surname",nullable=false)
	private String surname;
	@Column(name="identity_number",nullable=false,unique=true)
	private String identityNumber;
	@Column(name="birth_of_year")
	private String birthOfYear;
	@Column(name="password")
	private String password;
	@Column(name="password_again")
	private String passwordAgain;
	@Column(name="email_verified")
	private boolean emailVerified;
	@Column(name="email")
	private String email;
	
	
	
	
}
