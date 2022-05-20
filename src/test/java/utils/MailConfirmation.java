package utils;

import pages.utils.MailRuInboxFolderPage;
import pages.utils.MailRuMainPage;

public class MailConfirmation {

    MailRuMainPage mainPage = new MailRuMainPage();
    MailRuInboxFolderPage inboxFolderPage = new MailRuInboxFolderPage();

    public void confirmRegistration(String accountName, String password, String emailSubject) {
        mainPage.loginMailRu(accountName, password);
        inboxFolderPage.confirm(emailSubject);
    }
}
