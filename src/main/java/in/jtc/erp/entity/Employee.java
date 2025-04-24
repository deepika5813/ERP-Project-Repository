package in.jtc.erp.entity;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId", nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private Long phone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String position;
	
	@Column(nullable = false)
	private String department;
	
	private LocalDate joiningDate;
	
	@Column(name = "unique_employee_code", unique = true)
	private Long employeeId;
	
	@Column(nullable = false)
	private String supervisor;
	
	@Column(nullable = true)
	private String pastPosition;
	
	@Column(nullable = true)
	private String promotionDetails;
	
	@Column(nullable = true)
	private String departmentChange;
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private RolesAndResponsibilities role;*/
	
	/*@JsonIgnore
	private String address;
	@JsonIgnore
	private String emergencyContact;
	@JsonIgnore
	private String personalIdentificationNumber;*/
	
	/*Methods to expose only to the employee
	public String getAddressForSelf() {
		return address;
	}
	
	public String getEmergencyContactForSelf() {
		return emergencyContact;
	}
	
	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}*/
	
	/*Financial Details
	private Double baseSalary;
	private String bonus;
	private String allowances;
	private String deductions;
*/
}
