package utils;

import pages.utils.TrashmailMainPage;

public class CreatingTempMail {

    TrashmailMainPage mainPage = new TrashmailMainPage();
    private String tempEmail = null;

    public String getTempEmail() {
        return tempEmail;
    }

    public String createTempMail(String realEmail) {
        return mainPage.getMail(realEmail);
    }
}
