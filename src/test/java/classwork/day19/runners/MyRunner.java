package classwork.day19.runners;

import classwork.day21.MyHttpClient;
import classwork.day21.Search;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;

public class MyRunner {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, URISyntaxException {

        Search search = new Search("a", true);
        MyHttpClient myHttpClient = new MyHttpClient();
       myHttpClient.search(search);
    }
}
