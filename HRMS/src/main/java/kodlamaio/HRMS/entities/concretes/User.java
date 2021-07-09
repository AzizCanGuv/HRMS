package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="ID",nullable=false)
	private int ID;
	@Column(name="Email",unique=true,nullable=false)
	private String Email;
	@Column(name="Password",nullable=false)
	private String Password;
	public User(int iD, String email, String password) {
		super();
		ID = iD;
		Email = email;
		Password = password;
	}
	public User() {
		super();
		
	}
}
