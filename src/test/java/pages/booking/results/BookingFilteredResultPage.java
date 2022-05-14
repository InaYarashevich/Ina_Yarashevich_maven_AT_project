package pages.booking.results;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;

public class BookingFilteredResultPage extends BookingBasePage {

    private static final String THREE_DOTS_MENU_CSS = "a[aria-haspopup='true']";
    private static final String LOWEST_PRICE_FILTER_XPATH = "//*[text()='Price (lowest first)']";

    public void sortByLowestPrice() {
        driver.findElement(By.cssSelector(THREE_DOTS_MENU_CSS)).click();
        driver.findElement(By.xpath(LOWEST_PRICE_FILTER_XPATH)).click();
    }
}