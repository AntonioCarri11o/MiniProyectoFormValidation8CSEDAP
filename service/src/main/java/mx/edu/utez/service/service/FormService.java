package mx.edu.utez.service.service;

import jakarta.validation.*;
import mx.edu.utez.service.dto.FormDTO;
import mx.edu.utez.service.model.Form;
import mx.edu.utez.service.model.Select;
import mx.edu.utez.service.repository.FormRepository;
import mx.edu.utez.service.repository.SelectRepository;
import mx.edu.utez.service.utils.Utils;
import mx.edu.utez.service.validate.validators.MultipartFileContentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FormService {
    @Autowired
    FormRepository formRepository;
    @Autowired
    SelectRepository selectRepository;
    @Autowired
    CloudService cloudService;
    public Form save(FormDTO formDTO) throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<FormDTO>> violations = validator.validate(formDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        Optional<Select> select = selectRepository.findById(formDTO.getIdSelect());
        if (select.isEmpty()) {
            throw new Exception("Select no encontrado");
        }
        List<String> errors =  MultipartFileContentValidator.isValid(formDTO.getFile());
        if (!errors.isEmpty()) {
            throw new Exception(errors.toString());
        }
        formDTO.setSelect(select.get());
        formDTO.setToDate(Utils.parseStringDate(formDTO.getDate()));
        formDTO.setFileUrl(cloudService.saveFile(formDTO.getFile()));
        Form form = formDTO.getForm();
        return formRepository.save(form);
    }
}
