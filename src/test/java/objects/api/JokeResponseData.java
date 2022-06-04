package objects.api;

public class JokeResponseData {

    private String type;
    private Joke value;

    public JokeResponseData(String type, Joke value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getJoke() {
        return value;
    }

    public void setJoke(Joke joke) {
        this.value = joke;
    }

    @Override
    public String toString() {
        return "JokeResponseData{" +
                "type='" + type + '\'' +
                ", joke=" + value +
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
