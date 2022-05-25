package utils;

import classwork.day21.Search;
import gherkin.deps.com.google.gson.Gson;

import java.io.IOException;

public class Parser {
    public static String fromGSON(Search search) throws IOException {
        Gson gson = new Gson();
        return gson.toJson(search);
    }
}
