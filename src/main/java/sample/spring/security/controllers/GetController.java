package sample.spring.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @GetMapping("/")
    public String getRequest(){
        return "Returned by the get request";
    }

}
