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


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="computer_knowledges")
@NoArgsConstructor
@AllArgsConstructor


public class ComputerKnowledge {

	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="computer_knowledge_id")
	private int computerKnowledgeId;	
	

	@Column(name="computer_knowledge_description")
	@NotBlank
	@NotNull
	private String computerKnowledgeDescription;
	

   

    
	// many to one
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
}
