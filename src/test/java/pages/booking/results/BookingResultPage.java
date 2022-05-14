package pages.booking.results;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.booking.base.BookingBasePage;

import java.util.List;

public class BookingResultPage extends BookingBasePage {

    private static final String MAX_PRICE_FILTER_XPATH = "//input[@name='pri=5']/following-sibling::label/span";
    private static final String PROPERTY_CARD_XPATH = "//div[@data-testid='property-card']";
    private static final String HEART_BUTTON_CSS = "button[data-testid='wishlist-button']";
    private static final String PROFILE_MENU_CSS = "#profile-menu-trigger--content";
    private static final String WISHLIST_XPATH = "//span[contains(text(), 'Saved')]";
    private static final String HOTEL_TITLE_CSS = "div[data-testid='title']";

    public String getHotelTitle(int element){
        return driver.findElements(By.xpath(PROPERTY_CARD_XPATH))
                .get(element)
                .findElement(By.cssSelector(HOTEL_TITLE_CSS))
                .getText();
    }

    public void filterResults() {
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

    public void navigateToWishlist(){
        driver.findElement(By.cssSelector(PROFILE_MENU_CSS)).click();
        driver.findElement(By.xpath(WISHLIST_XPATH)).click();
    }
}
