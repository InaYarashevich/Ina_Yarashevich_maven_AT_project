package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.booking.base.BookingBasePage;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import static pages.booking.BookingHomepage.SEARCH_INPUT_FIELD_CSS;

public class BookingMainPage extends BookingBasePage {
    private static LocalDate currentDate = LocalDate.now();
    private static int currentDay = currentDate.getDayOfMonth();
    private static String checkInMonth = Arrays.stream(YearMonth.from(currentDate)
                    .plusMonths(1)
                    .getMonth()
                    .toString()
                    .split(""))
            .map(month -> month.substring(0, 1).toUpperCase() +
                    month.substring(1).toLowerCase(Locale.ROOT))
            .collect(Collectors.joining());
    private static String checkoutMonth = Arrays.stream(YearMonth.from(currentDate)
                    .plusMonths(1)
                    .getMonth()
                    .toString()
                    .split(""))
            .map(month -> month.substring(0, 1).toUpperCase() +
                    month.substring(1).toLowerCase(Locale.ROOT))
            .collect(Collectors.joining());
    private static int daysToStay;
    private static int checkInDay = currentDay;
    private static int checkOutDay = currentDay + daysToStay;
    private static String expectedCurrencyTooltipText;
    private static String expectedLanguageTooltipText;

    public static final String LISTBOX_XPATH = "//ul[@role='listbox']/li[1]";
    public static final String SEARCH_BUTTON_CSS = ".sb-searchbox__button";
    public static final String CHECKIN_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']", checkInDay, checkInMonth);
    public static final String CHECKOUT_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']", checkOutDay, checkoutMonth);
    private static final String NUMBER_OF_ADULTS_DROPDOWN_XPATH = "//span[contains(text(),'2 adults')]";
    private static final String INCREASE_NUMBER_OF_ADULTS_XPATH = "//span[text()='+']/parent::*[@aria-label='Increase number of Adults']";
    private static final String INCREASE_NUMBER_OF_ROOMS_XPATH = "//span[text()='+']/parent::button[@aria-label='Increase number of Rooms']";
    public static final String CURRENCY_XPATH = "//button[@data-tooltip-text='Choose your currency']";
    public static final String LANGUAGE_XPATH = "//button[@data-tooltip-text='Choose your currency']";
    private static final String REGISTER_BUTTON_XPATH = "//span[contains(text(), 'List your property')]/../../following-sibling::div/a/span[contains(text(), 'Register')]";
    private static final String SIGNIN_BUTTON_XPATH = "//nav[@class='bui-header__bar']//*[contains(text(),'Sign in')]/..";

    public static int getDaysToStay() {
        return daysToStay;
    }

    public static void setDaysToStay(int daysToStay) {
        BookingMainPage.daysToStay = daysToStay;
    }

    public static LocalDate getCurrentDate() {
        return currentDate;
    }

    public static int getCurrentDay() {
        return currentDay;
    }

    public static String getCheckInMonth() {
        return checkInMonth;
    }

    public static void setCheckInMonth(String checkInMonth) {
        BookingMainPage.checkInMonth = checkInMonth;
    }

    public static String getCheckoutMonth() {
        return checkoutMonth;
    }

    public static void setCheckoutMonth(String checkoutMonth) {
        BookingMainPage.checkoutMonth = checkoutMonth;
    }

    public int getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(int checkInDay) {
        this.checkInDay = checkInDay;
    }

    public int getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(int checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public void searchCity(String cityName) {
        WebElement city = driver.findElement(By.cssSelector(SEARCH_INPUT_FIELD_CSS));
        city.clear();
        city.sendKeys(cityName);
    }

    public void selectCheckInDate() {
        driver.findElement(By.xpath(CHECKIN_DATE_XPATH))
                .click();
    }

    public void selectCheckoutDate(int daysToStay) {
        driver.findElement(By.xpath(CHECKOUT_DATE_XPATH))
                .click();
    }

    public void selectNumberOfAdults() {
        driver.findElement(By.xpath(NUMBER_OF_ADULTS_DROPDOWN_XPATH))
                .click();
        WebElement numberOfAdults = driver.findElement(By
                .xpath(INCREASE_NUMBER_OF_ADULTS_XPATH));
        numberOfAdults.click();
        numberOfAdults.click();
    }

    public void selectNumberOfRooms() {
        driver.findElement(By.xpath(INCREASE_NUMBER_OF_ROOMS_XPATH))
                .click();
    }

    public void clickSearch() {
        driver.findElement(By.cssSelector(SEARCH_BUTTON_CSS)).click();
    }

    public String getCurrencyTooltipText() {
        WebElement currency = driver.findElement(By.xpath(CURRENCY_XPATH));
        return currency.getAttribute("data-tooltip-text");
    }

    public String getLanguageTooltipText() {
        WebElement language = driver.findElement(By.xpath(LANGUAGE_XPATH));
        return language.getAttribute("data-tooltip-text");
    }

    public void startRegistration() {
        driver.findElement(By.xpath(REGISTER_BUTTON_XPATH)).click();
    }

    public void clickSignIn() {
        driver.findElement(By.xpath(SIGNIN_BUTTON_XPATH)).click();
    }

    public static String getExpectedCurrencyTooltipText() {
        return expectedCurrencyTooltipText;
    }

    public static void setExpectedCurrencyTooltipText(String expectedCurrencyTooltipText) {
        BookingMainPage.expectedCurrencyTooltipText = expectedCurrencyTooltipText;
    }

    public static String getExpectedLanguageTooltipText() {
        return expectedLanguageTooltipText;
    }

    public static void setExpectedLanguageTooltipText(String expectedLanguageTooltipText) {
        BookingMainPage.expectedLanguageTooltipText = expectedLanguageTooltipText;
    }
}
