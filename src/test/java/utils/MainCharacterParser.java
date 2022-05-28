package utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import objects.api.MainCharacter;

import java.io.FileReader;
import java.io.IOException;

public class MainCharacterParser {

    private static final String JSON = "src/test/resources/testData/mainCharacter.json";

    public static MainCharacter parseData() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new JsonReader(new FileReader(JSON)), MainCharacter.class);
    }
}
