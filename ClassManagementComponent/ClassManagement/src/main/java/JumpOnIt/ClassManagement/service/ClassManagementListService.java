package JumpOnIt.ClassManagement.service;

import JumpOnIt.ClassManagement.model.ClassManagement;
import JumpOnIt.ClassManagement.model.paging.Page;
import JumpOnIt.ClassManagement.model.paging.Paged;
import JumpOnIt.ClassManagement.model.paging.Paging;
import JumpOnIt.ClassManagement.repository.ClassManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassManagementListService {
    final ClassManagementRepository classManagementRepository;

    @Autowired
    public ClassManagementListService(ClassManagementRepository classManagementRepository) {
        this.classManagementRepository = classManagementRepository;
    }


    public List<ClassManagement> prepareClassList(){
        return new ArrayList<>(classManagementRepository
                .findAll());
    }


    public Paged prepareClassList(int pageNumber, int size) {


        try {
            List<ClassManagement> classManagementClasses = new ArrayList<>(classManagementRepository
                    .findAll());

            int totalPages = ( (classManagementClasses.size() - 1 ) / size ) +1 ;
            int skip = pageNumber > 1 ? (pageNumber - 1) * size : 0;

            List<ClassManagement> paged = classManagementClasses.stream()
                    .skip(skip)
                    .limit(size)
                    .collect(Collectors.toList());

            return new Paged(new Page<>(paged, totalPages), Paging.of(totalPages, pageNumber, size));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Paged<>();
    }

    public void saveCreatedClass(ClassManagement newClass){
        classManagementRepository.save(newClass);
    }

}
