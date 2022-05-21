package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.booking.base.BookingBasePage;

import static pages.booking.BookingMainPage.*;

public class BookingHomepage extends BookingBasePage {

    private static final String ONBOARDING_MODAL_CSS = "#genius-onboarding-title";
    private static final String BOOKING_LOGO_CSS = ".bui-header__logo";
    private static final String CUSTOMER_SERVICE_CSS = "a[data-tooltip-text='Contact Customer Service']";
    private static final String NOTIFICATIONS_BELL_ICON_CSS = "button[data-text='View your notifications']";
    private static final String PROPERTY_ICON_XPATH = "//span[contains(text(), 'List your property')]";
    private static final String PROFILE_MENU_CSS = "#profile-menu-trigger--content";
    private static final String HEADER_NAVIGATION_CSS = "header .bui-tab__nav";
    private static final String WELCOME_POPUP_CLOSE_BUTTON_CSS = ".modal-mask-closeBtn";
    private static final String MANAGE_ACCOUNT_XPATH = "//span[contains(text(),'Manage account')]";
    public static final String SEARCH_INPUT_FIELD_CSS = "#ss";

    public void setCheckInDate(){
        driver.findElement(By.xpath(CHECKIN_DATE_XPATH))
                .click();
    }

    public void setCheckoutDate(){
        driver.findElement(By.xpath(CHECKOUT_DATE_XPATH))
                .click();
    }

    public void clickSearch(){
        driver.findElement(By.cssSelector(SEARCH_BUTTON_CSS)).click();
    }

    public void searchCity(String cityName) {
        WebElement city = driver.findElement(By.cssSelector(SEARCH_INPUT_FIELD_CSS));
        city.clear();
        city.sendKeys(cityName);
        driver.findElement(By.xpath(LISTBOX_XPATH)).click();
    }

    public void getAccountSettingsPage() {
        driver.findElement(By.cssSelector(PROFILE_MENU_CSS)).click();
        driver.findElement(By.xpath(MANAGE_ACCOUNT_XPATH)).click();
    }

    public void closeWelcomePopup() {
        if (driver.findElement(By.cssSelector(WELCOME_POPUP_CLOSE_BUTTON_CSS)).isDisplayed()){
            System.out.println(driver.findElement(By.cssSelector(WELCOME_POPUP_CLOSE_BUTTON_CSS)).isDisplayed());
            driver.findElement(By.cssSelector(WELCOME_POPUP_CLOSE_BUTTON_CSS)).click();
        }
    }

    public WebElement getWebElement(String element) {
        WebElement webElement = null;
        switch (element) {
            case "BOOKING_LOGO":
                webElement = driver.findElement(By.cssSelector(BOOKING_LOGO_CSS));
                break;
            case "CURRENCY":
                webElement = driver.findElement(By.xpath(CURRENCY_XPATH));
                break;
            case "LANGUAGE":
                webElement = driver.findElement(By.xpath(LANGUAGE_XPATH));
                break;
            case "PROFILE_MENU":
                webElement = driver.findElement(By.cssSelector(PROFILE_MENU_CSS));
                break;
            case "CUSTOMER_SERVICE":
                webElement = driver.findElement(By.cssSelector(CUSTOMER_SERVICE_CSS));
                break;
            case "NOTIFICATIONS_BELL_ICON":
                webElement = driver.findElement(By.cssSelector(NOTIFICATIONS_BELL_ICON_CSS));
                break;
            case "YOUR_PROPERTY_ICON":
                webElement = driver.findElement(By.xpath(PROPERTY_ICON_XPATH));
                break;
            case "HEADER_NAVIGATION":
                webElement = driver.findElement(By.cssSelector(HEADER_NAVIGATION_CSS));
                break;
        }
        return webElement;
    }

    public WebElement getGreeting() {
        return driver.findElement(By.cssSelector(ONBOARDING_MODAL_CSS));
    }
}
