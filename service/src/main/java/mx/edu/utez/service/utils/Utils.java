package mx.edu.utez.service.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date parseStringDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        return format.parse(dateString);
    }
}
