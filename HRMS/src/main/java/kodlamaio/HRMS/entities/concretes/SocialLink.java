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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="social_links")
@NoArgsConstructor
@AllArgsConstructor
public class SocialLink {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="social_link_id")
	private int socialLinkId;
	
	
	@Column(name="social_link_github")
	private String socialLinkGithub;
	
	@Column(name="social_link_linkedin")
	private String socialLinkLinkedin;
	
	@Column(name="social_link_webpage")
	private String socialLinkWebpage;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curriculum_vitae_id")
	@JsonBackReference
	private CurriculumVitae curriculumVitae;
	
}
