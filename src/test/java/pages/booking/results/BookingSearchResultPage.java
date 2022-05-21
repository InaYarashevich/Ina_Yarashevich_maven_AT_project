package pages.booking.results;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import pages.booking.base.BookingBasePage;

import java.util.List;

public class BookingSearchResultPage extends BookingBasePage {

    private static final String MAX_PRICE_FILTER_XPATH = "//input[@name='pri=5']/following-sibling::label/span";
    private static final String PROPERTY_CARD_XPATH = "//div[@data-testid='property-card']";
    private static final String HEART_BUTTON_CSS = "button[data-testid='wishlist-button']";
    private static final String PROFILE_MENU_CSS = "#profile-menu-trigger--content";
    private static final String WISHLIST_XPATH = "//span[contains(text(), 'Saved')]";
    private static final String HOTEL_TITLE_XPATH = "//div[@data-testid='title']";
    private static final String SUPERB_REVIEW_SCORE_FILTER_XPATH = "//div[@data-filters-group='review_score']//input[@value='review_score=90']/../label/span";
    private static final String HOTEL_RATING_XPATH = "//div[@data-testid='review-score-right-component']/div[@aria-label]";
    private static final String CALENDAR_CSS = "button[data-testid='date-display-field-start']";


    public String getHotelTitle(int element) {
        return driver.findElements(By.xpath(PROPERTY_CARD_XPATH))
                .get(element)
                .findElement(By.xpath(HOTEL_TITLE_XPATH))
                .getText();
    }

    public long getHotelRating() {
        return Long.parseLong(driver.findElement(By.xpath(HOTEL_RATING_XPATH))
                .getText()
                .replaceAll("[\\D]", ""));
    }

    public void openHotelDetailsPage(int orderNumber) {
        List<WebElement> hotels = driver.findElements(By.xpath(HOTEL_TITLE_XPATH));
        try {
            hotels.get(orderNumber).click();
        } catch (ElementClickInterceptedException exception) {
            driver.findElement(By.cssSelector(CALENDAR_CSS)).click();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            driver.navigate().refresh();
        }
    }

    public void filterResultsByMaxRating() {
        driver.findElement(By.xpath(SUPERB_REVIEW_SCORE_FILTER_XPATH)).click();
    }

    public void filterResultsByMaxPrice() {
        driver.findElement(By.xpath(MAX_PRICE_FILTER_XPATH)).click();
    }

    public List<WebElement> getResults() {
        return driver.findElements(By.xpath(PROPERTY_CARD_XPATH));
    }

    public void addToWishlist(int element) {
        driver.findElements(By.xpath(PROPERTY_CARD_XPATH))
                .get(element)
                .findElement(By.cssSelector(HEART_BUTTON_CSS))
                .click();
    }

    public void navigateToWishlist() {
        driver.findElement(By.cssSelector(PROFILE_MENU_CSS)).click();
        driver.findElement(By.xpath(WISHLIST_XPATH)).click();
    }
}
