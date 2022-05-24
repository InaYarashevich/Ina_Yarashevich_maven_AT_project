package classwork.day20;

import classwork.day21.Search;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.stream.JsonReader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyParser {

    private static final String JSON = "src/test/resources/testData/recipe.json";
    private static final String XML = "src/test/resources/testData/recipe.xml";

    public void parseGSON() throws FileNotFoundException {

        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON)), Recipe.class);

        System.out.println(recipe.getRecipename());
        System.out.println(recipe.getIngredlist());
        System.out.println(recipe.getPreptime());
    }

    public static String fromGSON(Search search) throws IOException {
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient("tomato", 3));
        ingredientList.add(new Ingredient("cucumber", 2));
        ingredientList.add(new Ingredient("mozzarella", 1));
        ingredientList.add(new Ingredient("olive oil", 3));
        Recipe recipe = new Recipe("salad", ingredientList, 120);
        //new BufferedWriter(new FileWriter("D:/test.txt")).write(gson.toJson(search));
        return gson.toJson(search);
    }

    public void parseDOM() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(XML);
        System.out.println(file);
        Document doc = builder.parse(file);
        System.out.println(doc.getElementsByTagName("recipename").item(0).getTextContent());
    }
}
