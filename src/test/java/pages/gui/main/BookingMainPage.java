package pages.gui.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.gui.base.BookingBasePage;
import utils.DateUtils;


import static pages.gui.main.BookingHomepage.SEARCH_INPUT_FIELD_CSS;

public class BookingMainPage extends BookingBasePage {
    public static final String LISTBOX_XPATH = "//ul[@role='listbox']/li[1]";
    public static final String SEARCH_BUTTON_CSS = ".sb-searchbox__button";
    public static final String CHECKIN_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']",
            DateUtils.checkInDay, DateUtils.getCheckInMonth);
    public static final String CHECKOUT_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']",
            DateUtils.checkoutDay, DateUtils.getCheckoutMonth);
    private static final String NUMBER_OF_ADULTS_DROPDOWN_XPATH = "//span[contains(text(),'2 adults')]";
    private static final String INCREASE_NUMBER_OF_ADULTS_XPATH = "//span[text()='+']/parent::*[@aria-label='Increase number of Adults']";
    private static final String INCREASE_NUMBER_OF_ROOMS_XPATH = "//span[text()='+']/parent::button[@aria-label='Increase number of Rooms']";
    public static final String CURRENCY_XPATH = "//button[@data-tooltip-text='Choose your currency']";
    public static final String LANGUAGE_XPATH = "//button[@data-tooltip-text='Choose your currency']";
    private static final String REGISTER_BUTTON_XPATH = "//span[contains(text(), 'List your property')]/../../following-sibling::div/a/span[contains(text(), 'Register')]";
    private static final String SIGNIN_BUTTON_XPATH = "//a[(contains(@class,'js-header-login-link'))]/span[contains(.,'Sign in')]";

    private static final String INCREASE_NUMBER_OF_CHILDREN_XPATH = "//span[text()='+']/parent::*[@aria-label='Increase number of Children']";

    public void searchCity(String cityName) {
        WebElement city = driver.findElement(By.cssSelector(SEARCH_INPUT_FIELD_CSS));
        city.clear();
        city.sendKeys(cityName);
        driver.findElement(By.xpath(LISTBOX_XPATH)).click();
    }

    public void selectCheckInDate() {
        driver.findElement(By.xpath(CHECKIN_DATE_XPATH))
                .click();
    }

    public void selectCheckoutDate(int daysToStay) {
        driver.findElement(By.xpath(CHECKOUT_DATE_XPATH))
                .click();
    }

    public void selectNumberOfVisitors(int numOfAdults, int numOfChildren) {
        WebElement numberOfAdults = driver.findElement(By.xpath(INCREASE_NUMBER_OF_ADULTS_XPATH));
        WebElement numberOfChildren = driver.findElement(By.xpath(INCREASE_NUMBER_OF_CHILDREN_XPATH));

        driver.findElement(By.xpath(NUMBER_OF_ADULTS_DROPDOWN_XPATH))
                .click();
        for (int i = 0; i < numOfAdults; i++) {
            numberOfAdults.click();
        }
        for (int i = 0; i < numOfChildren; i++) {
            numberOfChildren.click();
        }
    }

    public void selectNumberOfRooms(int numOfRooms) {
        for (int i = 0; i < numOfRooms; i++) {
            driver.findElement(By.xpath(INCREASE_NUMBER_OF_ROOMS_XPATH))
                    .click();
        }
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
}
