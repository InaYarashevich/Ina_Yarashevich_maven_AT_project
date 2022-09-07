package utils;

import pages.gui.utils.TrashmailMainPage;

public class CreatingTempMail {
    TrashmailMainPage mainPage = new TrashmailMainPage();
    private String tempEmail;

    public String getTempEmail() {
        return tempEmail;
    }

    public void setTempEmail(String tempEmail){
        this.tempEmail = tempEmail;
    }

    public String createTempMail(String realEmail) {
        return mainPage.getMail(realEmail);
    }
}
