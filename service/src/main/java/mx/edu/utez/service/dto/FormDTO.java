package mx.edu.utez.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import mx.edu.utez.service.model.Form;

@Getter @Setter
public class FormDTO {
    @NotBlank(message = "Propiedad text requerida")
    @Size(min = 10, max = 20, message = "El campo de texto debe tener entre 10 y 20 caracteres")
    @Pattern(regexp = "^(?=.*\\S).+$", message = "El campo texto no puede contener solo espacios en blanco")
    private String text;

    @NotBlank(message = "Propiedad card_number requerida")
    @Pattern(regexp = "^[0-9]{16}$", message = "Número de tarjeta inválido")
    private String card_number;
    @NotBlank(message = "Propiedad rfc requerida")
    @Pattern(regexp = "^([A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1})$", message = "Formato inválido pendejo")
    private String rfc;



    public Form convertToForm() {
        return new Form(this.text);
    }
}
