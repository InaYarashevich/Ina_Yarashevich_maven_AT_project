package utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import objects.api.JokesResponseData;

import java.io.FileReader;
import java.io.IOException;

public class JokesResponseDataParser {

    private static final String JSON = "src/test/resources/testData/jokesCountData.json";

    public static JokesResponseData parseData() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(new JsonReader(new FileReader(JSON)), JokesResponseData.class);
    }
}
