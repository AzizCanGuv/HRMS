package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="images")
@NoArgsConstructor
@AllArgsConstructor

public class Image {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="image_id")
	private int id;
	
	
	@Column(name="image_url")
	@NotNull
	@NotBlank
	private String imageUrl;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curriculum_vitae_id")
	@JsonBackReference
	private CurriculumVitae curriculumVitae;
	
}
