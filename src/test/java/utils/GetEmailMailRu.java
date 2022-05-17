package utils;

import pages.utils.MailRuInboxFolderPage;
import pages.utils.MailRuMainPage;

public class GetEmailMailRu {

    MailRuMainPage mainPage = new MailRuMainPage();
    MailRuInboxFolderPage inboxFolderPage = new MailRuInboxFolderPage();

    public void getEmail(String accountName, String password) {
        mainPage.loginMailRu(accountName, password);
        inboxFolderPage.confirm("One click to confirm");
    }
}
