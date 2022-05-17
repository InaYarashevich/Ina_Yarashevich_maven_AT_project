package utils;

import pages.utils.TrashmailMainPage;

public class CreatingTempMail {

    TrashmailMainPage mainPage = new TrashmailMainPage();

    public void createTempMail(String realEmail) {
        mainPage.getMail(realEmail);
    }
}
