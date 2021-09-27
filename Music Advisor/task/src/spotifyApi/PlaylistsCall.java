package spotifyApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class PlaylistsCall implements ApiCall{

    private String cNameId;

    public PlaylistsCall(String cName) {
        this.cNameId = CategoryCall.getIdByName(cName);
    }

    @Override
    public List<String> execute() {


        HttpResponse<String> response = API.get("browse/categories/" + cNameId + "/playlists");

        if(response.body().contains("error")) {
            return List.of(JsonParser.parseString(response.body()).getAsJsonObject().getAsJsonObject("error").get("message").getAsString());
        }

        JsonObject body = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject playlists = body.getAsJsonObject("playlists");

        List<String> playlistsData = new ArrayList<String>();

        JsonArray items = playlists.getAsJsonArray("items");


        for(JsonElement item : items) {
            String name = item.getAsJsonObject().get("name").getAsString();
            String link = item.getAsJsonObject().getAsJsonObject("external_urls").get("spotify").getAsString();

            String data = name + "\n" +
                    link + "\n";


            playlistsData.add(data);
        }

        return playlistsData;
    }
}
