package objects.gui;

import java.net.URL;
import java.util.List;

public class Email {

    private List<String> links;

    public Email(List<String> links) {
        this.links = links;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Email{" +
                "links=" + links +
                '}';
    }
}
