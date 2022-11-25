package aetios.digital.peopleApiProject.service;

import aetios.digital.peopleApiProject.dto.request.PeopleDTO;
import aetios.digital.peopleApiProject.dto.response.MessageResponseDTO;
import aetios.digital.peopleApiProject.entity.People;
import aetios.digital.peopleApiProject.exception.PeopleNotFoundException;
import aetios.digital.peopleApiProject.mapper.PeopleMapper;
import aetios.digital.peopleApiProject.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service //Gerencia Classe Responsavel pela regra de negócio
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleService {

    private PeopleRepository peopleRepository;
    private final PeopleMapper peopleMapper = PeopleMapper.INSTANCE;


    public MessageResponseDTO createPeople(PeopleDTO peopleDTO){
        People peopleToSave = peopleMapper.toModel(peopleDTO);

        People savedPeople = peopleRepository.save(peopleToSave);
        return createdMessageResponse(savedPeople.getId(), "Created people with ID ");
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

    public MessageResponseDTO updateById (Long id, PeopleDTO peopleDTO) throws PeopleNotFoundException {
        verifyIfExists(id);

        People peopleToUpdate = peopleMapper.toModel(peopleDTO);

        People updatedPeople = peopleRepository.save(peopleToUpdate);
        return createdMessageResponse(updatedPeople.getId(),"Updated people with ID ");
    }

    private People verifyIfExists(Long id) throws PeopleNotFoundException{
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException(id));
    }

    private static MessageResponseDTO createdMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
