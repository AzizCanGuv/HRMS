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
@Table(name="projects")
@NoArgsConstructor
@AllArgsConstructor

public class Project {

	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;	
	
	
	@Column(name="project_name")
	@NotBlank
	@NotNull
	private String projectName;
	
	
	@Column(name="project_date")
	@NotBlank
	@NotNull
	private Date projectDate;
	
	
	@Column(name="project_description")
	@NotBlank
	@NotNull
	private String projectDescription;
	
	
	
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
}
