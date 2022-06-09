package pages.gui.utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class MailRuInboxFolderPage {
    public WebDriver driver = Driver.getWebDriver();
    private static final String EMAILS_SUBJECTS_LIST_CSS = ".llc__subject>div>span";
    private static final String CONFIRM_BUTTON_CSS = ".button-link_mr_css_attr";

    public MailRuInboxFolderPage() throws MalformedURLException {
    }

    public void openEmail(String subject) {

        List<WebElement> elements = driver.findElements(By.cssSelector(EMAILS_SUBJECTS_LIST_CSS));
        try{
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i)
                    .getText().contains(subject)) {
                elements.get(i).click();
                break;
            }
        }} catch (StaleElementReferenceException staleElementReferenceException){
            System.out.printf(String.format("Email with <%s> subject isn't found", subject));
        }
    }

    public void confirmEmail() {
        driver.findElement(By.cssSelector(CONFIRM_BUTTON_CSS)).click();
    }
}
