package kodlamaio.HRMS.entities.dtos;

import java.util.Date;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisementDto {

	
	
	private int id;
	private double maximumSalary;
	private double minimumSalary;
	private String numberOfOpenPositions;
	private boolean status;
	private Date startDate;
	private Date endDate;
	
	
	//Employer entity
	private String companyName;
	private String email;
	private String website;
	private String password;
	
	//Job position entity
	private String jobPositionName;
	private String description;
	
	//City entity
	private String cityName;
	
	
	
}
