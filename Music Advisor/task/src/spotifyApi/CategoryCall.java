package spotifyApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.http.HttpResponse;
import java.util.*;

public class CategoryCall implements ApiCall{

    private static Map<String,String> nameToId = new HashMap<>();

    public static String getIdByName(String name){
        if(nameToId.isEmpty()) {
            ApiCaller apiCaller = new ApiCaller();
            apiCaller.setApiCall(new CategoryCall());
            apiCaller.call();
        }
        return nameToId.getOrDefault(name.toLowerCase(),"notFound");
    }


    @Override
    public List<String> execute() {

        HttpResponse<String> response = API.get("browse/categories");

        JsonObject body = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject categories = body.getAsJsonObject("categories");

        List<String> names = new ArrayList<String>();

        JsonArray items = categories.getAsJsonArray("items");

        for(JsonElement item : items) {
            String name = item.getAsJsonObject().get("name").getAsString();
            String id = item.getAsJsonObject().get("id").getAsString();
            nameToId.put(name.toLowerCase(),
                    id);
            names.add(name);
        }

        return names;
    }
}
