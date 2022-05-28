package objects.gui;

public class MainPage {

    private int daysToStay;
    private int checkInDay;
    private int checkOutDay;
    private String currencyTooltipText;
    private String languageTooltipText;

    public MainPage(int daysToStay, int checkInDay, int checkOutDay, String currencyTooltipText, String languageTooltipText) {
        this.daysToStay = daysToStay;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.currencyTooltipText = currencyTooltipText;
        this.languageTooltipText = languageTooltipText;
    }

    public int getDaysToStay() {
        return daysToStay;
    }

    public void setDaysToStay(int daysToStay) {
        this.daysToStay = daysToStay;
    }

    public int getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(int checkInDay) {
        this.checkInDay = checkInDay;
    }

    public int getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(int checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public String getCurrencyTooltipText() {
        return currencyTooltipText;
    }

    public void setCurrencyTooltipText(String currencyTooltipText) {
        this.currencyTooltipText = currencyTooltipText;
    }

    public String getLanguageTooltipText() {
        return languageTooltipText;
    }

    public void setLanguageTooltipText(String languageTooltipText) {
        this.languageTooltipText = languageTooltipText;
    }

    @Override
    public String toString() {
        return "BookingMainPage{" +
                "daysToStay=" + daysToStay +
                ", checkInDay=" + checkInDay +
                ", checkOutDay=" + checkOutDay +
                ", currencyTooltipText='" + currencyTooltipText + '\'' +
                ", languageTooltipText='" + languageTooltipText + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
