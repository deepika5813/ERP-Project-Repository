package in.jtc.erp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.jtc.erp.entity.EmployeeDocument;
@Repository
public interface EmployeeDocumentRepository extends JpaRepository<EmployeeDocument,Long> {
	List<EmployeeDocument> findEmployeeById(Long id);

}
