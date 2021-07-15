package advisor;

public enum Config {

    SERVER_PATH("https://accounts.spotify.com"),
    AUTHORIZE_PATH("/authorize"),
    REDIRECT_URI("http://localhost:8080"),
    CLIENT_ID("890f9c4b0e8f4843b4a49b4b7180247f"),
    CLIENT_SECRET("13b7ee07c39f489bba7c2539dc6f3e70"),
    ACCESS_TOKEN(""),
    AUTH_CODE("");

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
