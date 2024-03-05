package mx.edu.utez.service.validate.validators;

import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class MultipartFileContentValidator {
    public static List<String> isValid(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        List<String> errors = new ArrayList<>();
        List<String> allowedContentTypes = Arrays.asList(
                "image/jpg",
                "image/png",
                "image/jpeg",
                "image/jfif"
        );
        if(fileName.length() > 20) {
            errors.add("El nombre del archivo debe ser menor a 20 caracteres ");
        }
        if (!allowedContentTypes.contains(contentType)) {
            errors.add("Solo archivos jpg,png,jpeg,jfif ");
        }
        if (fileName.isEmpty()) {
            errors.add("El nombre del archivo no puede ir vacío");
        }
        if(!fileName.matches("[a-zA-Z0-9.]+")) {
            errors.add("El nombre del archivo no debe tener caractereres especiales o solo espacios");
        }
        return errors;
    }
}
