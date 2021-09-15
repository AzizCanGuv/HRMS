package kodlamaio.HRMS.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="skills")
@NoArgsConstructor
@AllArgsConstructor

public class Skill {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="skill_id")
	private int skillId;	
	
	
	@Column(name="skill_description")
	@NotBlank
	@NotNull
	private String skillDescription;
	
	
	
	
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
}
