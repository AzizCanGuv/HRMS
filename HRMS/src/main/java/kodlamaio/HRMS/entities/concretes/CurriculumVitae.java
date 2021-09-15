package kodlamaio.HRMS.entities.concretes;



import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="curriculum_vitae")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="curriculumVitaeId" )

public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="curriculum_vitae_id")
	private int curriculumVitaeId;
	

	
	@OneToOne()
    @JoinColumn(name="user_id")
    private JobSeeker jobSeeker;
	
	@JsonManagedReference
	@OneToOne(mappedBy="curriculumVitae")
    private Image image;
	 
	@OneToOne(mappedBy="curriculumVitae")
	private SocialLink socialLink;
	
	
	@OneToMany(mappedBy="curriculumVitae")
	private List<ComputerKnowledge> computerKnowledges;
	
	@OneToMany(mappedBy="curriculumVitae")
	private List<Project> projects;
	
	@OneToMany(mappedBy="curriculumVitae")
	private List<Language> languages;
	
	@OneToMany(mappedBy="curriculumVitae")
	private List<WorkExperience> workExperiences;
	
	@OneToMany(mappedBy="curriculumVitae")
	private List<School> schools;
	
	@OneToMany(mappedBy="curriculumVitae")
    private List<Skill> skills;
	
	
	
	
}
