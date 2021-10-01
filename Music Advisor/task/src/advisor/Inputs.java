package advisor;

public enum Inputs {
    NEW("new"),
    FEATURED("featured"),
    CATEGORIES("categories"),
    PLAYLISTS("playlists"),
    EXIT("exit"),
    AUTH("auth"),
    NEXTPAGE("next"),
    PREVIOUSPAGE("prev");

    String text;

    Inputs (String text){
        this.text = text;
    }

    public String get() {
        return text;
    }
}
