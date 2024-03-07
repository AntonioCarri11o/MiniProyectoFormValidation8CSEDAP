package mx.edu.utez.service.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.service.model.Form;
import mx.edu.utez.service.model.Select;
import mx.edu.utez.service.validate.anotations.DateUp18Years;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FormDTO {
    Long id;
    @NotBlank(message = "Propiedad text requerida")
    @Size(min = 10, max = 20, message = "El campo de texto debe tener entre 10 y 20 caracteres")
    @Pattern(regexp = "^(?=.*\\S).+$", message = "El campo texto no puede contener solo espacios en blanco")
    private String text;

    @NotBlank(message = "Propiedad card_number requerida")
    @Pattern(regexp = "^[0-9]{16}$", message = "Número de tarjeta inválido")
    private String card_number;
    @NotBlank(message = "Propiedad rfc requerida")
    @Pattern(regexp = "^([A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}[A-Z0-9]{3})$", message = "Formato de rfc inválido")
    private String rfc;
    @NotBlank(message = "Propiedad email requerida")
    @Email
    private String email;
    @NotNull(message = "Propiedad number requerida")
    @Min(value = 10L, message = "El número debe ser mayor a 10")
    @Max(value = 30L, message = "El numero debe ser menor a 30")
    private Long number;
    @Pattern(regexp = "^([0-9]{4}-[0-9]{2}-[0-9]{2})$", message = "Formato de fecha yyyy-MM-dd")
    @DateUp18Years(message = "Debes tener al menos 18 anios")
    private String date;
    /*
    @NotNull(message = "Archivo requerido")
    private MultipartFile file;
    @NotNull(message = "Propiedad opción requerida")
    private Long idSelect;
    private String fileUrl;
    private Select select;
     */
    private Date toDate;



    public Form getForm() {
        return new Form(
                getId(),
                getText(),
                getCard_number(),
                getRfc(),
                getEmail(),
                getNumber(),
                getToDate()
        );
    }
}
