package classwork.day19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingResultPage extends BookingBasePage {

    private static final String PROPERTY_CARD_XPATH = "//div[@data-testid='property-card']";

    public int getResults(){
        List<WebElement> hotelsList = driver.findElements(By.xpath(PROPERTY_CARD_XPATH));
        return hotelsList.size();
    }
}
