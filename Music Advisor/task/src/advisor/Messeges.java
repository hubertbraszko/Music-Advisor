package advisor;

public enum Messeges {


    NEW_RELEASES("---NEW RELEASES---"),
    FEATURED("---FEATURED---"),
    CATEGORIES("---CATEGORIES---"),
    PLAYLISTS("---%s PLAYLISTS---"),
    EXIT("---GOODBYE!---"),
    SUCCESS("---SUCCESS---"),
    UNAUTHORIZED("Please, provide access for application."),
    AUTHLINK("https://accounts.spotify.com/authorize?" +
                     "client_id=" + "890f9c4b0e8f4843b4a49b4b7180247f" +
            "&redirect_uri=https://www.example.com&response_type=code");

    String msg;

    Messeges(String text) {
        this.msg = text;
    }

    public void print(String... strings) {
        System.out.println(String.format(msg, strings));
    }
}
