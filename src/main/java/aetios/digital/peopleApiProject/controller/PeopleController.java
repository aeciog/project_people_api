package aetios.digital.peopleApiProject.controller;

import aetios.digital.peopleApiProject.dto.request.PeopleDTO;
import aetios.digital.peopleApiProject.dto.response.MessageResponseDTO;
import aetios.digital.peopleApiProject.exception.PeopleNotFoundException;
import aetios.digital.peopleApiProject.service.PeopleService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleController {
    private PeopleService peopleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPeople(@RequestBody @Valid PeopleDTO peopleDTO){
        return peopleService.createPeople(peopleDTO);
    }

    @GetMapping
    public List<PeopleDTO> listAll(){
        return peopleService.listAll();
    }

    @GetMapping("/{id}")
    public PeopleDTO findById(@PathVariable Long id) throws PeopleNotFoundException {
        return peopleService.findById(id);
    }
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable  Long id, @RequestBody @Valid PeopleDTO peopleDTO) throws PeopleNotFoundException {
        return peopleService.updateById(id, peopleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws  PeopleNotFoundException {
        peopleService.delete(id);
    }

}
