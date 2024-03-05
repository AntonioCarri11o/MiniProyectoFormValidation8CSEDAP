package mx.edu.utez.service.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.service.model.Form;
import mx.edu.utez.service.model.Select;

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
    @Pattern(regexp = "^([A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}[A-Z][0-1]{3})$", message = "Formato de rfc inválido pendejo")
    private String rfc;
    @NotBlank(message = "Propiedad curp requerida")
    @Pattern(regexp = "^([A-Z]{1}[AEIOU]{1}[A-Z]{1}[A-Z]{1}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}[A-Z]{2}[aeiouAEIOU0-9\\\\s]{2}[0-9]{2})$",
            message = "Formato de curp inválido pendejo")
    private String curp;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Size(min = 10, max = 20, message = "EL numero debe ser entre 10 y 20")
    private Long number;
    private Date date;
    @NotNull
    private Long idSelect;
    private Select select;



    public Form getForm() {
        return new Form(
                getId(),
                getText(),
                getCard_number(),
                getRfc(),
                getCurp(),
                getEmail(),
                getNumber(),
                getDate(),
                getSelect()
        );
    }
}
