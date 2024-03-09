package mx.edu.utez.service.service;

import jakarta.validation.*;
import mx.edu.utez.service.dto.FormDTO;
import mx.edu.utez.service.model.Form;
import mx.edu.utez.service.repository.FormRepository;
import mx.edu.utez.service.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class FormService {
    @Autowired
    FormRepository formRepository;
    @Autowired
    CloudService cloudService;
    public Form save(FormDTO formDTO) throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<FormDTO>> violations = validator.validate(formDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        formDTO.setToDate(Utils.parseStringDate(formDTO.getDate()));
        Form form = formDTO.getForm();
        return formRepository.save(form);
    }

    public List<Form> list() { return formRepository.findAll(); }
}
