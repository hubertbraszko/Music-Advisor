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

    public void createServer(){

        Messeges.AUTHLINK.print();

        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(PORT),0);
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

            System.out.println("\nwaiting for code...");
            while (Config.AUTH_CODE.get().isBlank()) { Thread.sleep(10); }
            server.stop(10);
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Create server error");
        }

    }

    public void authRequest() {

        System.out.println("making http request for access_token...");
        System.out.println("response:");

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
            if (response != null && response.body().contains("access_token")) { parseAccessToken(response.body()); }
            assert response != null;
            System.out.println(response.body());
            Messeges.SUCCESS.print();

        } catch (InterruptedException | IOException e) { System.out.println("Error response"); }
    }


    private void parseAccessToken(String body) {
        JsonObject jo = JsonParser.parseString(body).getAsJsonObject();
        Config.ACCESS_TOKEN.set(jo.get("access_token").getAsString());
    }




//    private Server() throws IOException {
//
//        SERVER = HttpServer.create();
//        SERVER.bind(new InetSocketAddress(PORT), 0);
//        this.createContexts();
//        SERVER.start();
//
//        this.authRequest();
//
//    }

//    public static Server getServer() {
//        if(ServerInstance == null){
//            try {
//                ServerInstance = new Server();
//            } catch (IOException e) {
//                System.out.println("getServer Error");
//            }
//        }
//        return ServerInstance;
//    }

//    public void stop() {
//        SERVER.stop(1);
//    }

//    private void createContexts() {
//        SERVER.createContext("/", new HttpHandler() {
//            @Override
//            public void handle(HttpExchange httpExchange) throws IOException {
//                //String hello = "hello world";
//                //httpExchange.sendResponseHeaders(200, hello.length());
//                //httpExchange.getResponseBody().write(hello.getBytes());
//                //httpExchange.getResponseBody().close();
//                String query = httpExchange.getRequestURI().getQuery();
//                String info;
//                System.out.println(query);
//
//                if("error=access_denied".equals(query)){
//                    info = "Authorization code not found. Try again.";
//                }
//                else{
//                    info = "Got the code. Return back to your program.";
//                }
//                httpExchange.sendResponseHeaders(200, info.length());
//                httpExchange.getResponseBody().write(info.getBytes());
//                httpExchange.getResponseBody().close();
//
//                Config.AUTH_CODE.set(query.substring(5));
//            }
//        });
//    }
//    private void authRequest(){
//
//        System.out.println("making http request for access token");
//        System.out.println("response:");
//
//        try {
//            while (Config.AUTH_CODE.equals("")) {Thread.sleep(10);}
//        } catch (InterruptedException e) {
//            System.out.println("Thread exception");
//        }
//        System.out.println("code recived :" + Config.AUTH_CODE.get() );
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .uri(URI.create(Config.SERVER_PATH.get() + "/api/token"))
//                .POST(HttpRequest.BodyPublishers.ofString("grant_type=authorization_code" +
//                        "&code=" + Config.AUTH_CODE.get() +
//                        "&client_id=" + Config.CLIENT_ID.get() +
//                        "&client_secret=" + Config.CLIENT_SECRET.get() +
//                        "&redirect_uri=" + Config.REDIRECT_URI.get()))
//                .build();
//
//        try {
//            HttpClient client = HttpClient.newBuilder().build();
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
//            Config.ACCES_TOKEN.set(jsonResponse.get("access_token").getAsString());
//
//        } catch (InterruptedException | IOException e) {
//            System.out.println("Error response");
//        }
//    }
}
