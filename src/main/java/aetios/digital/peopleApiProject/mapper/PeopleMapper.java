package aetios.digital.peopleApiProject.mapper;


import aetios.digital.peopleApiProject.dto.request.PeopleDTO;
import aetios.digital.peopleApiProject.entity.People;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleMapper {

    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    People toModel(PeopleDTO peopleDTO);

    PeopleDTO toDTO(People people);


}
