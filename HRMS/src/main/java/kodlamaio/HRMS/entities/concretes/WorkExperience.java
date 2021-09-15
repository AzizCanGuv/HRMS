package kodlamaio.HRMS.entities.concretes;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="work_experiences")
@NoArgsConstructor
@AllArgsConstructor

public class WorkExperience {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="work_experience_id")
	private int workExperienceId;
	
	
	@Column(name="work_experience_company_name")
	@NotBlank
	@NotNull
	private String workExperienceCompanyName;
	
	
	@Column(name="work_experience_position_name")
	@NotBlank
	@NotNull
	private String workExperiencePositionName;
	
	@Column(name="work_experience_start_date")
	private Date workExperienceStartDate;
	
	
	@Column(name="work_experience_end_date")
	private Date workExperienceEndDate;
	
	
	@Column(name="work_experience_still_working")
	private boolean workExperienceStillWorking; 
	
	
	@Column(name="work_experience_business_area")
	@NotBlank
	@NotNull
	private String workExperienceBusinessArea;
	
	
	@Column(name="work_experience_country")
	@NotBlank
	@NotNull
	private String workExperienceCountry;
	
	
	@Column(name="work_experience_city")
	@NotBlank
	@NotNull
	private String workExperienceCity;
	
	
	@Column(name="work_experience_description")
	private String workExperienceDescription;
	
	
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
}
