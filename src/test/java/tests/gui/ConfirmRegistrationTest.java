package tests.gui;

import driver.Config;
import driver.Driver;
import objects.gui.Email;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.gui.utils.HihomeEmailConfirmPage;
import utils.GetEmailGmail;

public class ConfirmRegistrationTest {

    GetEmailGmail getEmailGmail = new GetEmailGmail();
    HihomeEmailConfirmPage emailConfirmPage = new HihomeEmailConfirmPage();
    Email email = new Email(getEmailGmail.getVerificationLinks(getEmailGmail.readGmail()));
    private WebDriver driver = Driver.getWebDriver();

    public ConfirmRegistrationTest() throws Exception {
    }

    @BeforeClass
    public static void initDriver() {
        Driver.setConfig(Config.CHROME);

    }

    @Test
    public void confirmRegistration() throws Exception {
        for (int i = 0; i < getEmailGmail.getVerificationLinks(getEmailGmail.readGmail()).size(); i++) {
            driver.get(email.getLinks().get(i));
            Assert.assertTrue("<Go to Login> button is absent.", emailConfirmPage.goToLogin().isDisplayed());
        }
    }

    @After
    public void finish() {
        Driver.destroy();
    }
}
