package JumpOnIt.ClassManagement.repository;

import JumpOnIt.ClassManagement.model.ClassManagement;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ClassManagementRepository extends CrudRepository<ClassManagement, Long> {
    List<ClassManagement> findAll();
    List<ClassManagement> findAllByClassID(long classID);


}
