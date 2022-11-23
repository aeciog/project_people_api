package aetios.digital.peopleApiProject.service;

import aetios.digital.peopleApiProject.dto.request.PeopleDTO;
import aetios.digital.peopleApiProject.dto.response.MessageResponseDTO;
import aetios.digital.peopleApiProject.entity.People;
import aetios.digital.peopleApiProject.exception.PeopleNotFoundException;
import aetios.digital.peopleApiProject.mapper.PeopleMapper;
import aetios.digital.peopleApiProject.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    public List<PeopleDTO> listAll() {
        List<People> allPerson = peopleRepository.findAll();
        return allPerson.stream()
                .map(peopleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PeopleDTO findById(Long id) throws PeopleNotFoundException {
        People people = verifyIfExists(id);
        return peopleMapper.toDTO(people);
    }

    public void delete(Long id) throws PeopleNotFoundException {
        verifyIfExists(id);

        peopleRepository.deleteById(id);
    }


    private People verifyIfExists(Long id) throws PeopleNotFoundException{
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException(id));
    }
}
