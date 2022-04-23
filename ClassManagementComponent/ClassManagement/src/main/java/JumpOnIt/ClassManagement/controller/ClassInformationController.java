package JumpOnIt.ClassManagement.controller;

import JumpOnIt.ClassManagement.model.ClassManagement;
import JumpOnIt.ClassManagement.repository.ClassManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassInformationController {

    final ClassManagementRepository classManagementRepository;

    @Autowired
    public ClassInformationController(ClassManagementRepository classManagementRepository) {
        this.classManagementRepository = classManagementRepository;
    }

    @GetMapping("/classes")
    public List<ClassManagement> getClasses(){
        return new ArrayList<>(classManagementRepository
                .findAll());
    }

    @GetMapping("/classes/{classID}")
    public List<ClassManagement> getClasses(@PathVariable long classID){
        return new ArrayList<>(classManagementRepository
                .findAllByClassID(classID));
    }
}
