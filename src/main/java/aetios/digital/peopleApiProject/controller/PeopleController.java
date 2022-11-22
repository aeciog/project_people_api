package aetios.digital.peopleApiProject.controller;



import aetios.digital.peopleApiProject.dto.response.MessageResponseDTO;
import aetios.digital.peopleApiProject.entity.People;

import aetios.digital.peopleApiProject.service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService personService) {
        this.peopleService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPeople(@RequestBody People people){
        return peopleService.createPeople(people);
    }

}
