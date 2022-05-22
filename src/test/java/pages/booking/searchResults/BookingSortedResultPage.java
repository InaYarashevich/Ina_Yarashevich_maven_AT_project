package pages.booking.searchResults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.booking.base.BookingBasePage;

public class BookingSortedResultPage extends BookingBasePage {

    private static final String HOTEL_PRICE_XPATH = "//div[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']/span";
    private static final String MAX_PRICE_XPATH = "//div[@data-filters-item='pri:pri=5']//div[@data-testid='filters-group-label-content']";

    public int getHotelPrice() {

        WebElement hotelPriceElement = driver.findElement(By.xpath(HOTEL_PRICE_XPATH));

        String hotelPrice = hotelPriceElement.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(hotelPrice) / 7;
    }

    public int getMaxPrice() {

        WebElement maxPricePerNightElement = driver.findElement(By.xpath(MAX_PRICE_XPATH));

        String maxPricePerNight = maxPricePerNightElement.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(maxPricePerNight);
    }
}
