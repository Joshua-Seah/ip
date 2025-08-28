import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
    // fields
    public static final DateTimeFormatter DISPLAY_FORMAT_DATE = DateTimeFormatter.ofPattern("dd MMM yy");
    public static final DateTimeFormatter DISPLAY_FORMAT_TIME = DateTimeFormatter.ofPattern("dd MMM yy HH:mm a");

    // constructor

    // methods
    public static LocalDateTime getStandard(String in) {
        LocalDateTime out;

        try {
            if (in.length() == 10) {
                in += " 00:00 am";
            }
            out = LocalDateTime.parse(in, DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a"));
        } catch (Exception e) {
            throw new WrongTimeFormatException("Oops wrong date format! Try YYYY-MM-DD HH:MM am/pm");
        }
        return out;
    }

    public static String getDate(LocalDateTime dateTime) {
        return dateTime.format(DISPLAY_FORMAT_DATE);
    }

    public static String getTime(LocalDateTime dateTime) {
        return dateTime.format(DISPLAY_FORMAT_TIME);
    }

}
