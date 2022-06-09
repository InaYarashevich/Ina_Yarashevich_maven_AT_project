package objects.gui;

public class BookingHotel {

    private String title;
    private String titleColor;

    public BookingHotel(String title, String titleColor) {
        this.title = title;
        this.titleColor = titleColor;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookingHotel{" +
                "title='" + title + '\'' +
                ", titleColor='" + titleColor + '\'' +
                '}';
    }
}
