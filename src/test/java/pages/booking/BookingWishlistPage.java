package pages.booking;

import org.openqa.selenium.By;
import pages.booking.base.BookingBasePage;

public class BookingWishlistPage extends BookingBasePage {

    private static final String CAROUSEL_ITEM_CSS = ".bui-carousel__item";
    private static final String SAVED_HOTEL_TITLE_CSS = "a[class='js-listview-book js-listview-hotel-title']";

    public String getSavedHotelTitle(int element){
       return
               driver.findElements(By.cssSelector(CAROUSEL_ITEM_CSS))
                .get(element)
                .findElement(By.cssSelector(SAVED_HOTEL_TITLE_CSS))
                .getText();
    }
}
