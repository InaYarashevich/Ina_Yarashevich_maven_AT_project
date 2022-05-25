package objects.api;

import java.util.List;

public class JokesResponseData {

    private String type;
    private List<Joke> jokes;
    private int numberOfJokes;

    public JokesResponseData(String type, List<Joke> jokes, int numberOfJokes) {
        this.type = type;
        this.jokes = jokes;
        this.numberOfJokes = numberOfJokes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }

    public int getNumberOfJokes() {
        return numberOfJokes;
    }

    public void setNumberOfJokes(int numberOfJokes) {
        this.numberOfJokes = numberOfJokes;
    }

    @Override
    public String toString() {
        return "JokesResponseData{" +
                "type='" + type + '\'' +
                ", jokes=" + jokes +
                ", numberOfJokes=" + numberOfJokes +
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
