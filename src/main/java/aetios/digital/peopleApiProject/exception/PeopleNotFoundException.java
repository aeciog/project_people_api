package aetios.digital.peopleApiProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PeopleNotFoundException extends Throwable {
    public PeopleNotFoundException(Long id) {
        super("People not found with ID " + id);
    }
}
