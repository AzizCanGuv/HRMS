package kodlamaio.HRMS.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="languages")
@NoArgsConstructor
@AllArgsConstructor
public class Language {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="language_id")
	private int languageId;
	
	@NotNull
	@NotBlank
	@Column(name="language_name")
	private String languageName;
	
	@Min(1)
    @Max(5)
	@NotNull
	@NotBlank
	@Column(name="language_level")
	private int languageLevel;
	
	
	
	
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;

	
	
	
	
	
	
	
	
	
	
}
