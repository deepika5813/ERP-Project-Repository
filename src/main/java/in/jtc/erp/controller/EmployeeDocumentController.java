package in.jtc.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jtc.erp.entity.EmployeeDocument;
import in.jtc.erp.service.EmployeeDocumentService;

@RestController
@RequestMapping("/document")
public class EmployeeDocumentController {
	@Autowired
	private EmployeeDocumentService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDocument>> getAll(){
		List<EmployeeDocument> emDoc = service.getAllDocuments();
		return ResponseEntity.ok(emDoc);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDocument> getDocumentById(@PathVariable Long id){
		return service.getEmployeeDocumentyId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
		
	@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteDocument(@PathVariable Long id){
			try {
				service.deleteDocument(id);
				return ResponseEntity.noContent().build();
			}catch(RuntimeException e) {
				return ResponseEntity.notFound().build();
			}
		}
		
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDocument> updateDocument(@PathVariable Long id, @RequestBody EmployeeDocument updated ){
		EmployeeDocument updateDoc = service.updateDocument(id, updated);
		return ResponseEntity.ok(updateDoc);
		
	}
	
	

}
