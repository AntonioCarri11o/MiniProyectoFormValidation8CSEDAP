package mx.edu.utez.service.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;
import mx.edu.utez.service.utils.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
public class DateUp18YearsValidator implements ConstraintValidator<DateUp18Years, String> {
    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {
        if (date == null || date.isEmpty()) {
            return false;
        }
        Date toDate =  new Date();
        try {
            toDate = Utils.parseStringDate(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar currentDateLess18Years = Calendar.getInstance();
        currentDateLess18Years.add(Calendar.YEAR, -18);
        return toDate.before(currentDateLess18Years.getTime());
    }
}

