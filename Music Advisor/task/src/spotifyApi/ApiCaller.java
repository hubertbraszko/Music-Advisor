package spotifyApi;

import java.util.List;

public class ApiCaller {

    private ApiCall apiCall;
    private boolean update;


    public void setApiCall(ApiCall apiCall){
        this.apiCall = apiCall;
        this.update = true;
    }

    public List<String> call(){
        if(update) {
            this.update = false;
            return apiCall.execute();

        }
        return null;
    }
}
