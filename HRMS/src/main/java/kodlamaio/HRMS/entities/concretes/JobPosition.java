package kodlamaio.HRMS.entities.concretes;

import java.lang.annotation.Annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kodlamaio.HRMS.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")


public class JobPosition implements IEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int ID;
	@Column(name="name",nullable=false)
	private String Name;
	@Column(name="description",nullable=false)
	private String Description;
	public JobPosition(int iD, String name, String description) {
		super();
		ID = iD;
		Name = name;
		Description = description;
	}
	public JobPosition() {
		super();
	}
	
	

	
	
}
