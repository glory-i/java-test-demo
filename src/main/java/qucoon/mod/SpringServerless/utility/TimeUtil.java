package qucoon.mod.SpringServerless.utility;


import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDateTime;


public class TimeUtil {

    private static final ZoneId ZONE = ZoneId.of("GMT+1");

    private static final DateTimeFormatter DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZONE);

    public static String getTime() {
        ZonedDateTime now = ZonedDateTime.now(ZONE);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a, '(GMT+1)'", Locale.ENGLISH);
        return now.format(timeFormatter);
    }

    public static String getDate() {
        ZonedDateTime now = ZonedDateTime.now(ZONE);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
        return now.format(dateFormatter);
    }

    public static String getCurrentDateTimeString() {
        LocalDateTime nowAtZone = LocalDateTime.now(ZONE);
        return nowAtZone.format(DATETIME_FORMATTER);
    }

    public long secondsToMilliseconds(int seconds) {
        return seconds * 1000L;
    }

    public long minuteToMilliseconds(int minutes) {
        return minutes * 1000L * 60L;
    }

    public long hoursToMilliseconds(int hours) {
        return hours * 1000L * 60L * 60L;
    }

    public long daysToMilliseconds(int days) {
        return days * 24L * 1000L * 60L * 60L;
    }
}

