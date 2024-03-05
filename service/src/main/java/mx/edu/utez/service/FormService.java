package mx.edu.utez.service;

import jakarta.validation.*;
import mx.edu.utez.service.dto.FormDTO;
import mx.edu.utez.service.model.Form;
import mx.edu.utez.service.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FormService {
    @Autowired
    FormRepository formRepository;
    public Form save(FormDTO formDTO) {
        Form form = formDTO.getForm();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<FormDTO>> violations = validator.validate(formDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return formRepository.save(form);
    }
}
