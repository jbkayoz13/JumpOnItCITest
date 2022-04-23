package JumpOnIt.ClassManagement.controller;

import JumpOnIt.ClassManagement.service.ClassManagementListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewClassController {

    private final ClassManagementListService classManagementListService;

    @Autowired
    public ViewClassController(ClassManagementListService classManagementListService){
        this.classManagementListService=classManagementListService;
    }

    @GetMapping("/ViewClasses")
    public String list(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(value = "size", required = false, defaultValue = "10") int size, Model model) {
        model.addAttribute("CreatedClasses", classManagementListService.prepareClassList(pageNumber, size));

        return "ViewClasses";
    }

}
