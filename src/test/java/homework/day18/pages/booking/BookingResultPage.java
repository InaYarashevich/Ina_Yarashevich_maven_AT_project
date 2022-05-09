package homework.day18.pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingResultPage extends BookingBasePage {

    private static final String MAX_PRICE_FILTER_XPATH = "//input[@name='pri=5']/following-sibling::label/span";
    private static final String PROPERTY_CARD_XPATH = "//div[@data-testid='property-card']";


    public void filterResults() {
        driver.findElement(By.xpath(MAX_PRICE_FILTER_XPATH)).click();
    }

    public List<WebElement> getResults() {
        return driver.findElements(By.xpath(PROPERTY_CARD_XPATH));
    }
}
