package advisor;

public enum Messeges {

    NEW_RELEASES("---NEW RELEASES---"),
    FEATURED("---FEATURED---"),
    CATEGORIES("---CATEGORIES---"),
    PLAYLISTS("---%s PLAYLISTS---"),
    EXIT("---GOODBYE!---");


    String msg;

    Messeges(String text) {
        this.msg = text;
    }

    public void print(String... strings) {
        System.out.println(String.format(msg, strings));
    }
}
