package pages.gui.searchResults;

import org.openqa.selenium.*;
import pages.gui.base.BookingBasePage;

import java.util.List;

public class BookingSearchResultPage extends BookingBasePage {

    private static final String MAX_PRICE_FILTER_XPATH = "//input[@name='pri=5']/following-sibling::label/span[2]";
    private static final String MIN_PRICE_FILTER_XPATH = "//input[@name='pri=2']/following-sibling::label/span";
    private static final String PRI4_PRICE_FILTER_XPATH = "//input[@name='pri=4']/following-sibling::label/span";
    private static final String PRI3_PRICE_FILTER_XPATH = "//input[@name='pri=3']/following-sibling::label/span";
    private static final String PROPERTY_CARD_XPATH = "//div[@data-testid='property-card']";
    private static final String HEART_BUTTON_CSS = "button[data-testid='wishlist-button']";
    private static final String PROFILE_MENU_CSS = "#profile-menu-trigger--content";
    private static final String WISHLIST_XPATH = "//span[contains(text(), 'Saved')]";
    private static final String HOTEL_TITLE_XPATH = "//div[@data-testid='title']";
    private static final String SUPERB_REVIEW_SCORE_FILTER_XPATH = "//div[@data-filters-group='review_score']//input[@value='review_score=90']/../label/span";
    private static final String VERY_GOOD_REVIEW_SCORE_FILTER_XPATH = "//div[@data-filters-group='review_score']//input[@value='review_score=80']/../label/span";
    private static final String GOOD_REVIEW_SCORE_FILTER_XPATH = "//div[@data-filters-group='review_score']//input[@value='review_score=70']/../label/span";
    private static final String PLEASANT_REVIEW_SCORE_FILTER_XPATH = "//div[@data-filters-group='review_score']//input[@value='review_score=60']/../label/span";
    private static final String HOTEL_RATING_XPATH = "//div[@data-testid='review-score-right-component']/div[@aria-label]";
    private static final String CALENDAR_CSS = "button[data-testid='date-display-field-start']";
    private static final String CHECKIN_CALENDAR_XPATH = "//div[contains(text(), 'Check-in date')]";
    private static final String THREE_DOTS_MENU_CSS = "a[aria-haspopup='true']";
    private static final String LOWEST_PRICE_FILTER_XPATH = "//*[text()='Price (lowest first)']";
    private static final String HOTEL_PRICE_XPATH = "//div[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']/span";
    private static final String MAX_PRICE_XPATH = "//div[@data-filters-item='pri:pri=5']//div[@data-testid='filters-group-label-content']";

    public void closeCalendar() {
        driver.findElement(By.xpath(CHECKIN_CALENDAR_XPATH)).click();
    }

    public String getHotelTitle(int element) {
        return driver.findElements(By.xpath(PROPERTY_CARD_XPATH))
                .get(element)
                .findElement(By.xpath(HOTEL_TITLE_XPATH))
                .getText();
    }

    public double getHotelRating() {
        double rating =
                Double.parseDouble(driver.findElement(By.xpath(HOTEL_RATING_XPATH))
                        .getText()
                        .replaceAll("[\\D]", ""));
        System.out.println(rating);
        return rating;
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

    public void filterResultsByRating(String rating) {
        switch (rating) {
            case "SUPERB":
                driver.findElement(By.xpath(SUPERB_REVIEW_SCORE_FILTER_XPATH)).click();
                break;
            case "VERY GOOD":
                driver.findElement(By.xpath(VERY_GOOD_REVIEW_SCORE_FILTER_XPATH)).click();
                break;
            case "GOOD":
                driver.findElement(By.xpath(GOOD_REVIEW_SCORE_FILTER_XPATH)).click();
                break;
            case "PLEASANT":
                driver.findElement(By.xpath(PLEASANT_REVIEW_SCORE_FILTER_XPATH)).click();
                break;
        }
    }

    public void filterResultsByPrice(String price) {
        switch (price) {
            case "max":
                driver.findElement(By.xpath(MAX_PRICE_FILTER_XPATH)).click();
                break;
            case "min":
                driver.findElement(By.xpath(MIN_PRICE_FILTER_XPATH)).click();
                break;
            case "pri=4":
                driver.findElement(By.xpath(PRI4_PRICE_FILTER_XPATH)).click();
                break;
            case "pri=3":
                driver.findElement(By.xpath(PRI3_PRICE_FILTER_XPATH)).click();
                break;
        }
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

    public void sortByLowestPrice() {
        driver.findElement(By.cssSelector(THREE_DOTS_MENU_CSS)).click();
        driver.findElement(By.xpath(LOWEST_PRICE_FILTER_XPATH)).click();
    }

    public int getHotelPrice() {
        return Integer.parseInt(driver.findElement(By.xpath(HOTEL_PRICE_XPATH))
                .getText()
                .replaceAll("[^0-9]", "")) / 7;
    }

    public int getMaxPrice() {
        return Integer.parseInt(driver.findElement(By.xpath(MAX_PRICE_XPATH))
                .getText()
                .replaceAll("[^0-9]", ""));
    }
}
