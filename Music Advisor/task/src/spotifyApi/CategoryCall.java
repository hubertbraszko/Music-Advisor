package spotifyApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CategoryCall implements ApiCall{


    @Override
    public List<String> execute() {

        HttpResponse<String> response = API.get("browse/categories");

        JsonObject body = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject categories = body.getAsJsonObject("categories");

        List<String> names = new ArrayList<String>();

        JsonArray items = categories.getAsJsonArray("items");

        for(JsonElement item : items) {
            String name = item.getAsJsonObject().get("name").getAsString();
            names.add(name);
        }

        return names;
    }
}
