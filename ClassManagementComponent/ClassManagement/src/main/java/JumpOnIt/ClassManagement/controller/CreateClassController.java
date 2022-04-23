package JumpOnIt.ClassManagement.controller;

import JumpOnIt.ClassManagement.model.ClassManagement;
import JumpOnIt.ClassManagement.service.ClassManagementListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class CreateClassController {

    final ClassManagementListService classManagementService;

    @Autowired
    public CreateClassController(ClassManagementListService classManagementService) {
        this.classManagementService = classManagementService;
    }

    @GetMapping("/CreateClasses")
    public String showCreateClass (@ModelAttribute("CreateClasses") ClassManagement classManagement){

        return "CreateClasses";
    }

    @PostMapping("/CreateClasses")
    public String createClass (@Valid @ModelAttribute("CreateClasses") ClassManagement classManagement, BindingResult result){

        if(result.hasErrors()){
            System.out.println("There were errors.");
            return "CreateClasses";
        }

        classManagementService.saveCreatedClass(classManagement);
        return "redirect:CreateClasses";
    }
}
