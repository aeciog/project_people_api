package aetios.digital.peopleApiProject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PeopleController {

    @GetMapping
    public String getBook(){
        return "API TEST.";
    }
}
