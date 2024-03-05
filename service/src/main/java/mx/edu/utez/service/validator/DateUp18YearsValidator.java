package mx.edu.utez.service.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
public class DateUp18YearsValidator implements ConstraintValidator<DateUp18Years, Date> {
    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }
        Calendar currentDateLess18Years = Calendar.getInstance();
        currentDateLess18Years.add(Calendar.YEAR, -18);
        return date.before(currentDateLess18Years.getTime());
    }
}

