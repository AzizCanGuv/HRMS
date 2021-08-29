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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@NoArgsConstructor
@AllArgsConstructor


public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private int id;
	@Column(name="maximum_salary")
	private double maximumSalary;
	@Column(name="minimum_salary")
	private double minimumSalary;
	@Column(name="number_of_open_positions")
	private String numberOfOpenPositions;
	@Column(name="status")
	private boolean status;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name="id")
	private JobPosition jobPosition;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
}
