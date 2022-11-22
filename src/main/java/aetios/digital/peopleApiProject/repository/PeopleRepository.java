package aetios.digital.peopleApiProject.repository;

import aetios.digital.peopleApiProject.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
