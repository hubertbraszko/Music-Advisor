package advisor;

import java.net.http.HttpRequest;
import java.net.URI;

public class Request {
    public static HttpRequest request(String resource) {
        return HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + Config.ACCESS_TOKEN.get())
                .header("Content-type", "application/json")
                .uri(URI.create(Config.API_SERVER.get() + resource))
                .GET()
                .build();

    }
}
