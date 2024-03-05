package mx.edu.utez.service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateUp18YearsValidator.class)
public @interface DateUp18Years {
    String message() default "Debe ser mayor a 18 anios";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
