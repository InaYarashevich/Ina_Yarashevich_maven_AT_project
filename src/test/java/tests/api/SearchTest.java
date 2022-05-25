package tests.api;

import classwork.day21.Search;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import utils.SearchParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class SearchTest {

    @Test
    public void searchByFullNameShortTest() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(SearchParser.fromGSON(new Search("berta", false))));
        HttpResponse response = client.execute(request);
        Assert.assertNotNull("Search by full name 'short' does not return results.",
                EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void searchByFullNameLongTest() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(SearchParser.fromGSON(new Search("Simon Greath", true))));
        HttpResponse response = client.execute(request);
        Assert.assertNotNull("Search by full name 'long' does not return results.",
                EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void searchByPartialNameShortTest() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(SearchParser.fromGSON(new Search("Simo", false))));
        HttpResponse response = client.execute(request);
        Assert.assertNotNull("Search by partial name 'short' does not return results.",
                EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void searchByPartialNameLongTest() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(SearchParser.fromGSON(new Search("Simo", false))));
        HttpResponse response = client.execute(request);
        Assert.assertNotNull("Search by partial name 'long' does not return results.",
                EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void searchAllUsersTest() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(SearchParser.fromGSON(new Search("", false))));
        HttpResponse response = client.execute(request);
        Assert.assertNotNull("Search by All Users does not return results.",
                EntityUtils.toString(response.getEntity()));
    }
}
