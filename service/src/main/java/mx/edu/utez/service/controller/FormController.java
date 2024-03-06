package mx.edu.utez.service.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import mx.edu.utez.service.service.FormService;
import mx.edu.utez.service.dto.FormDTO;
import mx.edu.utez.service.utils.GlobalVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/form/")
@CrossOrigin(origins = GlobalVariable.CROSS_ORIGINS_URL)
public class FormController {
    @Autowired
    FormService formService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody FormDTO formDTO) {
        try {
            formService.save(formDTO);
            return ResponseEntity.ok("Registro exitoso");
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<?> violation : violations) {
                errorMessages.add(violation.getMessage());
            }
            return ResponseEntity.badRequest().body(errorMessages.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
