package advisor;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.net.InetSocketAddress;
import java.io.IOException;

public class Server {
    final int PORT = 8080;
    //  private final HttpServer SERVER;
    /// private static Server ServerInstance = null;

    public void createServer() {
        System.out.println("use this link to request the access code:");
        Messeges.AUTHLINK.print();

        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(PORT), 0);
            server.start();
            server.createContext("/",
                    exchange -> {
                        String query = exchange.getRequestURI().getQuery();
                        String request;

                        if (query != null && query.contains("code")) {
                            Config.AUTH_CODE.set(query.substring(5));
                            System.out.println("code received");
                            request = "Got the code. Return back to your program.";
                        } else {
                            request = "Authorization code not found. Try again.";
                        }

                        exchange.sendResponseHeaders(200, request.length());
                        exchange.getResponseBody().write(request.getBytes());
                        exchange.getResponseBody().close();
                    });

            System.out.println("waiting for code...");
            while (Config.AUTH_CODE.get().isBlank()) {
                Thread.sleep(10);
            }
            server.stop(10);

        } catch (IOException | InterruptedException e) {
            System.out.println("Create server error");
        }

    }

    public void authRequest() {

        System.out.println("Making http request for access_token...");


        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(Config.SERVER_PATH.get() + "/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "grant_type=authorization_code" +
                                "&code=" + Config.AUTH_CODE.get() +
                                "&client_id=" + Config.CLIENT_ID.get() +
                                "&client_secret=" + Config.CLIENT_SECRET.get() +
                                "&redirect_uri=" + Config.REDIRECT_URI.get()))
                .build();

        try {

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response != null && response.body().contains("access_token")) {
                parseAccessToken(response.body());
            }
            assert response != null;

            Messeges.SUCCESS.print();

        } catch (InterruptedException | IOException e) {
            System.out.println("Error response");
        }
    }


    private void parseAccessToken(String body) {
        JsonObject jo = JsonParser.parseString(body).getAsJsonObject();
        Config.ACCESS_TOKEN.set(jo.get("access_token").getAsString());
    }

}

