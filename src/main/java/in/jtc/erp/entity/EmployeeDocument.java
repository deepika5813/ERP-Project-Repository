package in.jtc.erp.entity;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name= "employee_documents")
public class EmployeeDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	@ManyToOne
	@JoinColumn(name= "employee_id")
	private Employee employee;
	@Column(name= "document_name", nullable = false)
	private String documentName;
	@Column(name= "document_type", nullable = false)
	private String documentType;
	@Lob
	@Column(name= "document_data", nullable = false)
	private byte[] documentData;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "uploaded_at", nullable = false)
	private Date uploadAt;

}
