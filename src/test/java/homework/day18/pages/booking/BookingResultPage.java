package homework.day18.pages.booking;

import org.openqa.selenium.By;

public class BookingResultPage extends BookingBasePage {

    private static final String MAX_PRICE_FILTER_XPATH = "//input[@name='pri=5']/following-sibling::label/span";

    public void filterResults() {

        driver.findElement(By.xpath(MAX_PRICE_FILTER_XPATH)).click();
    }
}
