package advisor;

public enum Config {

    SERVER_PATH("https://accounts.spotify.com"),
    AUTHORIZE_PATH("/authorize"),
    REDIRECT_URI("http://localhost:8080/"),
    CLIENT_ID(""),
    CLIENT_SECRET(""),
    ACCESS_TOKEN(""),
    AUTH_CODE(""),
    API_SERVER("https://api.spotify.com/v1/"),
    ITEMSPERPAGE("5");


    String text;

    Config(String text) {
        this.text = text;
    }

    public void set(String text) {
        this.text = text;
    }

    public String get() {
        return text;
    }
}
