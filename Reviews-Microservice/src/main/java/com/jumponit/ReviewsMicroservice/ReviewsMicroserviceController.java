package com.jumponit.ReviewsMicroservice;

import org.springframework.web.bind.annotation.RestController;

/***
 * This microservice is responsible with getting the details of a particular
 * class and returning to the MVC structure.
 */
@RestController
public class ReviewsMicroserviceController {

    final WebClient client;
    String classServiceURI = "http://localhost:8086/";



}
