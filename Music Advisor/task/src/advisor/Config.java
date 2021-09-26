package advisor;

public enum Config {

    SERVER_PATH("https://accounts.spotify.com"),
    AUTHORIZE_PATH("/authorize"),
    REDIRECT_URI("http://localhost:8080/"),
    CLIENT_ID("890f9c4b0e8f4843b4a49b4b7180247f"),
    CLIENT_SECRET("4d3d40487d30473fbe31c6a607baef6e"),
    ACCESS_TOKEN(""),
    AUTH_CODE(""),
    API_SERVER("https://api.spotify.com/v1/");


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
