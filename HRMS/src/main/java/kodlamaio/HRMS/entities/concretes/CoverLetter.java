package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cover_letters")
@NoArgsConstructor
@AllArgsConstructor

public class CoverLetter {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cover_letter_id")
	private int coverLetterId;
	
	@Column(name="cover_letter_name")
	private String coverLetterName;
	
	@Column(name="cover_letter_description")
	private String coverLetterDescription;
	
	@OneToOne()
	@JoinColumn(name="jobSeeker_id")
	private JobSeeker jobSeeker;
	
	
	
}
