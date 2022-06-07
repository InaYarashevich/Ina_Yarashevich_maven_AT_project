package objects.gui;

public class SearchResults {

    private double ratingFilterValue;
    private double price;

    public SearchResults(double ratingFilterValue, double price) {
        setRatingFilterValue(90);
        setPrice(800);
    }

    public SearchResults() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRatingFilterValue() {
        return ratingFilterValue;
    }

    public void setRatingFilterValue(double ratingFilterValue) {
        this.ratingFilterValue = ratingFilterValue;
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "ratingFilterValue=" + ratingFilterValue +
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
