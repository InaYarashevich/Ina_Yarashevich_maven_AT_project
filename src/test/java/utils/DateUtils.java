package utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.YearMonth;

public class DateUtils {
    private static LocalDate currentDate = LocalDate.now();
    public static int currentDay = currentDate.getDayOfMonth();
    private static String checkInMonth = YearMonth.from(currentDate)
                    .plusMonths(1)
                    .getMonth()
                    .toString();
    private static String checkoutMonth = YearMonth.from(currentDate)
            .plusMonths(1)
            .getMonth()
            .toString();

    public static String getCheckoutMonth = StringUtils.capitalize(checkoutMonth);

    public static String getCheckInMonth = StringUtils.capitalize(checkInMonth);

}
