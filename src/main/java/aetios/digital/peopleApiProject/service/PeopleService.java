package aetios.digital.peopleApiProject.service;

import aetios.digital.peopleApiProject.dto.response.MessageResponseDTO;
import aetios.digital.peopleApiProject.entity.People;
import aetios.digital.peopleApiProject.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //Gerencia Classe Responsavel pela regra de negócio
public class PeopleService {

    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public MessageResponseDTO createPeople(People people){
        People savedPeople = peopleRepository.save(people);
        return MessageResponseDTO
                .builder()
                .message("Created people with ID " + savedPeople.getId())
                .build();
    }
}
