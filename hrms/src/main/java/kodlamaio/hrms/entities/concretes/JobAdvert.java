package kodlamaio.hrms.entities.concretes;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_adverts")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id" , nullable = false)
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position_count")
	private Integer openPositionCount;
	
	@Column(name="create_date")
	private LocalDateTime createDate = LocalDateTime.now();
	
	@Column(name="last_apply_date")
	private Date lastApplyDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle; 

}
