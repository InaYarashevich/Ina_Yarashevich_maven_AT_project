package objects.api;

import java.util.List;

public class JokesResponseData {

    private String type;
    private List<Joke> value;

    public JokesResponseData(String type, List<Joke> value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Joke> getValue() {
        return value;
    }

    public void setValue(List<Joke> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JokesResponseData{" +
                "type='" + type + '\'' +
                ", value=" + value +
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
