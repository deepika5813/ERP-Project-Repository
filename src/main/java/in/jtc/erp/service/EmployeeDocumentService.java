package in.jtc.erp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jtc.erp.Repository.EmployeeDocumentRepository;
import in.jtc.erp.entity.EmployeeDocument;

@Service
public class EmployeeDocumentService {
	@Autowired
	private EmployeeDocumentRepository repo;

	public EmployeeDocumentService(EmployeeDocumentRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<EmployeeDocument> getAllDocuments() {
		return repo.findAll();
		
	}
	
	 public Optional<EmployeeDocument> getEmployeeDocumentyId(Long id){
		 return repo.findById(id);
	 }
	 
	 public void deleteDocument(Long id) {
		 repo.deleteById(id);
	 }
	 
	 public EmployeeDocument updateDocument(Long id, EmployeeDocument updateDoc) {
		 Optional<EmployeeDocument> existDoc = repo.findById(id);
		 if(existDoc.isPresent()) {
			 EmployeeDocument document = existDoc.get();
			 document.setDocumentData(updateDoc.getDocumentData());
			 document.setDocumentName(updateDoc.getDocumentName());
			 document.setDocumentType(updateDoc.getDocumentType());
			 document.setEmployee(updateDoc.getEmployee());
			 document.setUploadAt(updateDoc.getUploadAt());
			 return repo.save(document);
		 }else {
			 throw new RuntimeException("No data found: "+id);
		 }
			 
		
	 }

}
