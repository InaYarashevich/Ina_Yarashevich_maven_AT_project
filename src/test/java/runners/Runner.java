package runners;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        String checkInMonth = Arrays.stream(YearMonth.from(currentDate)
                        .plusMonths(1)
                        .getMonth()
                        .toString()
                        .split(""))
                .map(month -> month.substring(0, 1).toUpperCase() +
                        month.substring(1).toLowerCase(Locale.ROOT))
                .collect(Collectors.joining());
        System.out.println(checkInMonth);
    }
}
