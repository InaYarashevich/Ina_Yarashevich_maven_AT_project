package classwork.day19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class BookingMainPage extends BookingBasePage {

    private static final String SEARCH_FIELD_XPATH = "//input[@type='search']";
    public static final String LISTBOX_XPATH = "//ul[@role='listbox']/li[1]";
    private static final String SEARCH_BUTTON_XPATH = "//button[@class='sb-searchbox__button ']";

    public BookingMainPage() throws MalformedURLException {
    }


    public void searchCity(String cityName) {
        WebElement city = driver.findElement(By.xpath(SEARCH_FIELD_XPATH));
        city.clear();
        city.sendKeys(cityName);
        driver.findElement(By.xpath(LISTBOX_XPATH)).click();
    }
}
