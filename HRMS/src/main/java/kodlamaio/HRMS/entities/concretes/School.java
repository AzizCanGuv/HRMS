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
@Table(name="schools")
@NoArgsConstructor
@AllArgsConstructor

public class School {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	
	@Column(name="school_name")
	@NotBlank
	@NotNull
	private String schoolName;
	
	
	@Column(name="school_grade")
	@NotBlank
	@NotNull
	private String schoolGrade;
	
	
	@Column(name="school_scholarship_amount")
	@NotBlank
	@NotNull
	private String scholarshipAmount;
	
	@Column(name="school_period_start")
	private Date schoolPeriodStart;
	
	@Column(name="school_period_end")
	private Date schoolPeriodEnd;
	
	
	@Column(name="school_status")
	private boolean isGraduated;
	
	
	@Column(name="school_department_name")
	private String departmentName;
	
	@Column(name="school_faculty_name")
	private String facultyName;
	

	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;

	
	
	
	
}
