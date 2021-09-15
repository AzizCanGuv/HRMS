package kodlamaio.HRMS.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers_table")
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="userId")
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id",nullable=false)
	private int userId;

	
	@Column(name="name",nullable=false)
	@NotBlank
	@NotNull
	private String name;
	
	@Column(name="surname",nullable=false)
	@NotBlank
	@NotNull
	private String surname;
	
	@Column(name="identity_number",nullable=false,unique=true)
	@NotBlank
	@NotNull
	private String identityNumber;
	
	@Column(name="birth_of_year")
	@NotBlank
	@NotNull
	private String birthOfYear;
	
	@NotBlank
	@NotNull
	@Column(name="password")
	private String password;

	@NotBlank
	@NotNull
	@Column(name="password_again")
	private String passwordAgain;
	
	@Column(name="email_verified")
	private boolean emailVerified;
	
	@NotBlank
	@NotNull
	@Email
	@Column(name="email")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CoverLetter> coverLetters;

	
	
    @OneToOne(mappedBy="jobSeeker")
    private CurriculumVitae curriculumVitae;
}
