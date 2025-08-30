package apleasebot.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import apleasebot.exceptions.WrongTimeFormatException;

/**
 * Encapsulates the logic that formats my time String->LocalDateTime->String
 */
public class TimeFormatter {
    public static final DateTimeFormatter DISPLAY_FORMAT_DATE = DateTimeFormatter.ofPattern("dd MMM yy");
    public static final DateTimeFormatter DISPLAY_FORMAT_TIME = DateTimeFormatter.ofPattern("dd MMM yy HH:mm a");

    /**
     * Method that converts my String time to LocalDateTine
     * @param in String time
     * @return LocalDateTime of the time input
     */
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

    /**
     * Method that converts my LocalDateTime to String time in a more readable date-only form
     * @param dateTime LocalDateTime object stored in task
     * @return String date
     */
    public static String getDate(LocalDateTime dateTime) {
        return dateTime.format(DISPLAY_FORMAT_DATE);
    }

    /**
     * Method that converts my LocalDateTime to String time in a more readable but full date-time form
     * @param dateTime LocalDateTime object stored in task
     * @return String time
     */
    public static String getTime(LocalDateTime dateTime) {
        return dateTime.format(DISPLAY_FORMAT_TIME);
    }

}
