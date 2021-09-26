package spotifyApi;

import java.util.List;

public class ApiCaller {

    private ApiCall apiCall;


    public void setApiCall(ApiCall apiCall){
        this.apiCall = apiCall;
    }

    public List<String> call(){
       return apiCall.execute();
    }
}
