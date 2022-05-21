package classwork.day20;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class MyParser {

    private static final String JSON = "src/test/resources/testData/recipe.json";

    public void parseGSON() throws FileNotFoundException {

        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);

        System.out.println(recipe.getRecipename());
        System.out.println(Arrays.toString(recipe.getIngredlist()));
        System.out.println(recipe.getPreptime());
    }
}
