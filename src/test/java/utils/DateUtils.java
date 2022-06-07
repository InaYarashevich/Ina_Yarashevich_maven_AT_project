package utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Locale;

public class DateUtils {
    private static LocalDate currentDate = LocalDate.now();
    public static int currentDay = currentDate.getDayOfMonth();
    private static String checkInMonth = YearMonth.from(currentDate)
            .plusMonths(1)
            .getMonth()
            .toString()
            .toLowerCase(Locale.ROOT);
    private static String checkoutMonth = YearMonth.from(currentDate)
            .plusMonths(1)
            .getMonth()
            .toString()
            .toLowerCase(Locale.ROOT);

    public static int checkInDay = currentDay + 3;
    public static int checkoutDay = checkInDay + 7;

    public static String getCheckInMonth = StringUtils.capitalize(checkInMonth);

    public static String getCheckoutMonth = StringUtils.capitalize(checkoutMonth);
}
