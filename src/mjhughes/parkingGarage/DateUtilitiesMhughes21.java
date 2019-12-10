package mjhughes.parkingGarage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Date Utilities
 * note: declare a LocalDateTime decDate=LocalDateTime.of(2019,12,4,7,0,0);
 */
public class DateUtilitiesMhughes21 {
    private static LocalDateTime start;
    private static LocalDateTime end;
    private static int hoursStayed;
    private static DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("hh a");
    private static DateTimeFormatter dateFormatter2= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /**
     * formatDate - returns the date/time in the predeclared format
     * @param dateToFormat
     * @return formatted date/time
     */
    public static String formatDate(LocalDateTime dateToFormat) {
        return dateToFormat.format(dateFormatter);
    }

    /**
     * calcStay: Facade-style method to calculate the hours (including partial hours)
     * @param enter LocalDateTime
     * @param leave LocalDateTime
     * @return int hours difference
     */
    public static int calcStay(LocalDateTime enter, LocalDateTime leave) {
        // Set up the variables
        setStart(enter);
        setEnd(leave);

        // Get the number of hours
        setHoursStayed(calcHours());
        // Get the number of minutes. If minutes>0, add another hour (any portion of an hour gets charged)
        if ((calcMinutes()-calcHours()*60)>0) {
            return getHoursStayed()+1;
        } else {
            return getHoursStayed();
        }

    }

    /**
     * calcHours
     * @return int hours
     */
    private static int calcHours() {
        return (int)start.until(end, ChronoUnit.HOURS);
    }

    /**
     * calcMinutes
     * @return int minutes
     */
    private static int calcMinutes() {
        return (int)start.until(end, ChronoUnit.MINUTES);
    }

    /**
     * getStart
     * @return LocalDateTime
     */
    public static LocalDateTime getStart() {
        return start;
    }

    /**
     * setStart
     * @param setStart LocalDateTime
     */
    public static void setStart(LocalDateTime setStart) {
        start = setStart;
    }

    /**
     * getEnd
     * @return LocalDateTime
     */
    public static LocalDateTime getEnd() {
        return end;
    }

    /**
     * setEnd
     * @param setEnd
     */
    public static void setEnd(LocalDateTime setEnd) {
        end = setEnd;
    }

    /**
     * getHoursStayed
     * @return int
     */
    public static int getHoursStayed() {
        return hoursStayed;
    }

    /**
     * setHoursStayed
     * @param setHoursStayed int
     */
    public static void setHoursStayed(int setHoursStayed) {
        hoursStayed = setHoursStayed;
    }

    /**
     * getCheckinTime
     * @return LocalDateTime
     */
    public static LocalDateTime getCheckinTime() {
        //        enter=LocalDateTime.of(2019,12,4,7,0,0);
        LocalDateTime thisDate=LocalDateTime.now();
        return LocalDateTime.of(thisDate.getYear(),
                thisDate.getMonth(), thisDate.getDayOfMonth(), getRandomNumber(7,12),
                0,0);
    }

    /**
     * getCheckoutTime
     * @return LocalDateTime
     */
    public static LocalDateTime getCheckoutTime() {
        //        enter=LocalDateTime.of(2019,12,4,7,0,0);
        LocalDateTime thisDate=LocalDateTime.now();
        return LocalDateTime.of(thisDate.getYear(),
                thisDate.getMonth(), thisDate.getDayOfMonth(), getRandomNumber(13,23),
                0,0);
    }

    /**
     * get a random integer between a min and max (inclusive).
     * @param min int
     * @param max int
     * @return int random number in the range
     */
    private static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}
