package advisor;

public enum Messeges {


    NEW_RELEASES("---NEW RELEASES---"),
    FEATURED("---FEATURED---"),
    CATEGORIES("---CATEGORIES---"),
    PLAYLISTS("---%s PLAYLISTS---"),
    EXIT("---GOODBYE!---"),
    SUCCESS("---SUCCESS---"),
    UNAUTHORIZED("Please, provide access for application."),
    AUTHLINK( Config.SERVER_PATH.get() + Config.AUTHORIZE_PATH.get() + "?" +
                     "client_id=" + Config.CLIENT_ID.get() +
            "&redirect_uri=" + Config.REDIRECT_URI.get() + "&response_type=code");

    String msg;

    Messeges(String text) {
        this.msg = text;
    }



    public void print(String... strings) {
        System.out.println(String.format(msg, strings));
    }
}
