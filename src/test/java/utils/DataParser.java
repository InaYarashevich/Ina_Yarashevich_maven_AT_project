package utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import objects.api.Joke;
import objects.api.JokesCountData;
import objects.api.MainCharacter;

import java.io.FileReader;
import java.io.IOException;

public class DataParser {

    private static final String JSON = "src/test/resources/testData/";
    private static Gson gson = new Gson();

    public static Joke parseJokesData() throws IOException {
        return gson.fromJson(new JsonReader(new FileReader(JSON + "jokes.json")), Joke.class);
    }

    public static JokesCountData parseJokesResponseData() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new JsonReader(new FileReader(JSON + "jokesCountData.json")), JokesCountData.class);
    }

    public static MainCharacter parseMainCharacterData() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new JsonReader(new FileReader(JSON + "mainCharacter.json")), MainCharacter.class);
    }
}
