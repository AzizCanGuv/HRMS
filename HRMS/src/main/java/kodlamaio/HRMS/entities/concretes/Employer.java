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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers_table")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"}) 
public class Employer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id",nullable=false)
	
	private int userId;
	
	@Column(name="company_name",nullable=false)
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name="website",nullable=false)
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name="email",nullable=false)
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name="password_again")
	@NotBlank
	@NotNull
	private String passwordAgain;
	
	
	@OneToMany(mappedBy="employer")
	List<JobAdvertisement> jobAdvertisements;
	
	
	
	
}
