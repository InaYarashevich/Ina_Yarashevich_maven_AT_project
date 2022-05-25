package utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import objects.api.Joke;

import java.io.FileReader;
import java.io.IOException;

public class JokesParser {

    private static final String JSON = "src/test/resources/testData/jokes.json";

    public static Joke parseData() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new JsonReader(new FileReader(JSON)), Joke.class);
    }
}
