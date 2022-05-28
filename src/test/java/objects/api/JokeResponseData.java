package objects.api;

public class JokeResponseData {

    private String type;
    private Joke joke;

    public JokeResponseData(String type, Joke joke) {
        this.type = type;
        this.joke = joke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    @Override
    public String toString() {
        return "JokeResponseData{" +
                "type='" + type + '\'' +
                ", joke=" + joke +
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
