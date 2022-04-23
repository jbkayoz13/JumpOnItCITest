package JumpOnIt.ClassManagementMicroservice.controller;


import JumpOnIt.ClassManagementMicroservice.model.ClassManagement;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ClassManagementMicroserviceController {
    private final WebClient webClient;

    @Autowired
    public ClassManagementMicroserviceController(WebClient.Builder builder){
        this.webClient = builder.baseUrl("http://localhost:7777/").build();
    }
    @Operation(summary = "Returns all created classes.")
    @GetMapping("/getClasses")
    public ClassManagement[] getClasses(){
        return webClient
                .get()
                .uri("/classes")
                .retrieve()
                .bodyToMono(ClassManagement[].class).block();
    }

    @Operation(summary = "Returns a class by its ID.")
    @GetMapping("/getClasses/{classID}")
    public ClassManagement[] getGlasses(@PathVariable long classID){
        return webClient
                .get()
                .uri("/classes/"+classID)
                .retrieve()
                .bodyToMono(ClassManagement[].class).block();
    }


}
