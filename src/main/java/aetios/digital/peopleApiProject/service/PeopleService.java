package aetios.digital.peopleApiProject.service;

import aetios.digital.peopleApiProject.dto.request.PeopleDTO;
import aetios.digital.peopleApiProject.dto.response.MessageResponseDTO;
import aetios.digital.peopleApiProject.entity.People;
import aetios.digital.peopleApiProject.mapper.PeopleMapper;
import aetios.digital.peopleApiProject.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //Gerencia Classe Responsavel pela regra de negócio
public class PeopleService {

    private PeopleRepository peopleRepository;
    private final PeopleMapper peopleMapper = PeopleMapper.INSTANCE;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public MessageResponseDTO createPeople(PeopleDTO peopleDTO){
        People peopleToSave = peopleMapper.toModel(peopleDTO);

        People savedPeople = peopleRepository.save(peopleToSave);
        return MessageResponseDTO
                .builder()
                .message("Created people with ID " + savedPeople.getId())
                .build();
    }
}
