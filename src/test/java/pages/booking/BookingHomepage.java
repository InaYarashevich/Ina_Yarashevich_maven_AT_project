package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.booking.base.BookingBasePage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class BookingHomepage extends BookingBasePage {

    private static LocalDate currentDate = LocalDate.now();
    private static int currentDay = currentDate.getDayOfMonth();
    private static String currentMonth = new SimpleDateFormat("MMMM").format(new Date());
    private static int checkInDate = currentDay + 3;
    private static int checkOutDate = checkInDate + 7;

    private static final String ONBOARDING_MODAL_CSS = "#genius-onboarding-title";
    private static final String BOOKING_LOGO_CSS = ".bui-header__logo";
    private static final String CURRENCY_XPATH = "//button[@data-tooltip-text='Choose your currency']";
    private static final String LANGUAGE_XPATH = "//button[@data-tooltip-text='Choose your currency']";
    private static final String CUSTOMER_SERVICE_CSS = "a[data-tooltip-text='Contact Customer Service']";
    private static final String NOTIFICATIONS_BELL_ICON_CSS = "button[data-text='View your notifications']";
    private static final String PROPERTY_ICON_XPATH = "//span[contains(text(), 'List your property')]";
    private static final String PROFILE_MENU_CSS = "#profile-menu-trigger--content";
    private static final String HEADER_NAVIGATION_CSS = "header .bui-tab__nav";
    private static final String CITY_SEARCH_FIELD_XPATH = "//input[@type='search']";
    private static final String LISTBOX_XPATH = "//ul[@role='listbox']/li[1]";
    private static final String SEARCH_BUTTON_XPATH = "//button[@class='sb-searchbox__button ']";
    private static final String CHECKIN_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']", checkInDate, currentMonth);
    private static final String CHECKOUT_DATE_XPATH = String.format("//span[@aria-label='%s %s 2022']", checkOutDate, currentMonth);
    private static final String NUMBER_OF_ADULTS_DROPDOWN_XPATH = "//span[contains(text(),'2 adults')]";
    private static final String INCREASE_NUMBER_OF_ADULTS_XPATH = "//span[text()='+']/parent::*[@aria-label='Increase number of Adults']";
    private static final String INCREASE_NUMBER_OF_ROOMS_XPATH = "//span[text()='+']/parent::button[@aria-label='Increase number of Rooms']";


    public void getHomepage() {

    }

    public WebElement getGreeting() {
        return driver.findElement(By.cssSelector(ONBOARDING_MODAL_CSS));
    }

    public WebElement getBookingLogoElement() {
        return driver.findElement(By.cssSelector(BOOKING_LOGO_CSS));
    }

    public WebElement getLanguageElement() {
        return driver.findElement(By.xpath(LANGUAGE_XPATH));
    }

    public WebElement getCurrencyElement() {
        return driver.findElement(By.xpath(CURRENCY_XPATH));
    }

    public WebElement getCustomerServiceElement() {
        return driver.findElement(By.cssSelector(CUSTOMER_SERVICE_CSS));
    }

    public WebElement getNotificationsBell() {
        return driver.findElement(By.cssSelector(NOTIFICATIONS_BELL_ICON_CSS));
    }

    public WebElement getPropertyIcon() {
        return driver.findElement(By.xpath(PROPERTY_ICON_XPATH));
    }

    public WebElement getProfileMenu() {
        return driver.findElement(By.cssSelector(PROFILE_MENU_CSS));
    }

    public WebElement getHeaderNavigation() {
        return driver.findElement(By.cssSelector(HEADER_NAVIGATION_CSS));
    }
}
