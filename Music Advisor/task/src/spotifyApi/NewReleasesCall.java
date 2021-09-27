package spotifyApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class NewReleasesCall implements ApiCall{

    @Override
    public List<String> execute() {
        HttpResponse<String> response = API.get("browse/new-releases");

        JsonObject body = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject albums = body.getAsJsonObject("albums");

        List<String> albumsData = new ArrayList<String>();

        JsonArray items = albums.getAsJsonArray("items");


        for(JsonElement item : items) {
            String name = item.getAsJsonObject().get("name").getAsString();
            String link = item.getAsJsonObject().getAsJsonObject("external_urls").get("spotify").getAsString();

            JsonArray artists = item.getAsJsonObject().get("artists").getAsJsonArray();
            List<String> artistNames = new ArrayList<String>();

            for(JsonElement artist : artists) {
                String artistName = artist.getAsJsonObject().get("name").getAsString();
                artistNames.add(artistName);
            }


            String data = name + "\n" +
                    artistNames.toString() + "\n" +
                    link + "\n";


            albumsData.add(data);
        }

        return albumsData;
    }

}
