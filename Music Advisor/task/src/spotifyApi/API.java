package spotifyApi;

import advisor.Request;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public static HttpResponse<String> get(String endpoint) {

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request = Request.request(endpoint);
        HttpResponse<String> response = null;

        try{
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }
}
