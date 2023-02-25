package ssf.day19_class.services;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import ssf.day19_class.model.News;

@Service
public class NewsServices {

    public final static String URL = "https://newsapi.org/v2/top-headlines";

    @Value("${api.key}")
    private String apiKey;

    public List<News> getNews(String country) {

        String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("country", country)
                .queryParam("apiKey", apiKey)
                .toUriString();

        System.out.println("URL >>> " + url);

        RequestEntity<Void> req = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        String payload = resp.getBody();

        // System.out.println("Payload>>>" + payload);

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject json = reader.readObject();

        // System.out.println("Json>>>" + json);

        JsonArray articles = json.getJsonArray("articles");

        // System.out.println("Json>>>" + articles.toString());

        News news; 

        List<News> list = new LinkedList<>();

        for (int i = 0; i < articles.size(); i++) {
            JsonObject article = articles.getJsonObject(i);
            String title = article.getString("title");
            String urlString = article.getString("url");
            String urlToImage = article.getString("urlToImage","null");
            news = new News(title, urlString, urlToImage);
            list.add(news);
        }

        System.out.println(list);

        return list;
        
    }

    


    
}
