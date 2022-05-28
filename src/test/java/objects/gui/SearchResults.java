package objects.gui;

public class SearchResults {

    private int ratingFilterValue;

    public SearchResults(int ratingFilterValue) {
        this.ratingFilterValue = ratingFilterValue;
    }

    public int getRatingFilterValue() {
        return ratingFilterValue;
    }

    public void setRatingFilterValue(int ratingFilterValue) {
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
