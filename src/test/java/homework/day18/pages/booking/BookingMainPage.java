package homework.day18.pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class BookingMainPage extends BookingBasePage {

    private static LocalDate currentDate = LocalDate.now();
    private static int currentDay = currentDate.getDayOfMonth();
    private static String currentMonth = new SimpleDateFormat("MMMM").format(new Date());
    private static int checkInDate = currentDay + 3;
    private static int checkOutDate = checkInDate + 7;
    private static String expectedCurrencyTooltipText = "Choose your currency";
    private static String expectedLanguageTooltipText = "Choose your language";

    private static final String SEARCH_FIELD_XPATH = "//input[@type='search']";
    private static final String LISTBOX_XPATH = "//ul[@role='listbox']/li[1]";
    private static final String SEARCH_BUTTON_XPATH = "//button[@class='sb-searchbox__button ']";
    private static final String CHECKIN_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']", checkInDate, currentMonth);
    private static final String CHECKOUT_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']", checkOutDate, currentMonth);
    private static final String NUMBER_OF_ADULTS_DROPDOWN_XPATH = "//span[contains(text(),'2 adults')]";
    private static final String INCREASE_NUMBER_OF_ADULTS_XPATH = "//span[text()='+']/parent::*[@aria-label='Increase number of Adults']";
    private static final String INCREASE_NUMBER_OF_ROOMS_XPATH = "//span[text()='+']/parent::button[@aria-label='Increase number of Rooms']";
    private static final String CURRENCY_XPATH = "//button[@data-tooltip-text='Choose your currency']";
    private static final String LANGUAGE_XPATH = "//button[@data-tooltip-text='Choose your currency']";


    public void searchCity(String cityName) {
        WebElement city = driver.findElement(By.xpath(SEARCH_FIELD_XPATH));
        city.clear();
        city.sendKeys(cityName);
    }

    public void selectCheckInDate() {
        driver.findElement(By.xpath(LISTBOX_XPATH)).click();
        driver.findElement(By.xpath(CHECKIN_DATE_XPATH))
                .click();
    }

    public void selectCheckoutDate() {
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

    public void search() {
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
    }

    public String getCurrencyTooltipText(){
        WebElement currency = driver.findElement(By.xpath(CURRENCY_XPATH));
        return currency.getAttribute("data-tooltip-text");
    }

    public String getLanguageTooltipText(){
        WebElement language = driver.findElement(By.xpath(LANGUAGE_XPATH));
        return language.getAttribute("data-tooltip-text");
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
