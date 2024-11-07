package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;

	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE", updatable=false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE" ,insertable = false)
	private LocalDate updateDate;

}
