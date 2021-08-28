package kodlamaio.HRMS.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions_table")
@AllArgsConstructor
@NoArgsConstructor

public class JobPosition  {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int ID;
	@Column(name="name",nullable=false)
	private String Name;
	@Column(name="description",nullable=false)
	private String Description;
	
	
	@OneToMany(mappedBy="jobPosition")
	private List<JobAdvertisement> jobAdvertisements;
	
	
}
