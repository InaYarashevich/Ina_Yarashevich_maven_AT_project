package pages.utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailRuInboxFolderPage {
    public WebDriver driver = Driver.getWebDriver();
    private static final String EMAILS_SUBJECTS_LIST_CSS = ".llc__subject>div>span";
    private static final String UNREAD_EMAIL_CLASS_VALUE_CSS = ".llc__subject";
    private static final String CONFIRM_BUTTON_CSS = ".button-link_mr_css_attr";
    private static final String EMAIL_XPATH = "//div[contains(.,'Hello')]/a[1]";

    public void confirm(String subject) {

        List<WebElement> elements = driver.findElements(By.cssSelector(EMAILS_SUBJECTS_LIST_CSS));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i)
                    .getText().contains(subject)) {
                elements.get(i).click();
            }

            driver.findElement(By.cssSelector(CONFIRM_BUTTON_CSS)).click();
        }
    }
}
