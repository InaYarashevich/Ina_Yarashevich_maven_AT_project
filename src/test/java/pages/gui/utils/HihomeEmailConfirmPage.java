package pages.gui.utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.gui.base.BookingBasePage;

public class HihomeEmailConfirmPage extends BookingBasePage {

    private static final String GO_TO_LOGIN_XPATH = "//*[text()='Go to login']";
    private WebDriver driver = Driver.getWebDriver();

    public WebElement goToLogin(){
        return driver.findElement(By.xpath(GO_TO_LOGIN_XPATH));
    }
}
