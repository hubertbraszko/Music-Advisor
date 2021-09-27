package advisor;


import spotifyApi.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.stream.Collectors;


public class UserTextInterface {

    private Scanner scanner = new Scanner(System.in);
    private boolean authorized = false;

    private ApiCaller apiCaller = new ApiCaller();

    public UserTextInterface() {

    }

    private String getInput() {
        return scanner.nextLine();
    }

    private String responseMessage;
    private List<String> response;

    private Server server;


    public void start() {



        String input = getInput();

        if (input.equals(Inputs.EXIT.get())) {

            Messeges.EXIT.print();

            System.exit(0);

        } else if(!authorized) {

           if(input.equals(Inputs.AUTH.get()))
           {

               authorize();
               authorized = true;

           }
           else {
               Messeges.UNAUTHORIZED.print();
           }
           
       } else {

           if(input.equals(Inputs.NEW.get())){

               Messeges.NEW_RELEASES.print();

               apiCaller.setApiCall(new NewReleasesCall());

           } else if (input.equals(Inputs.FEATURED.get())) {

               Messeges.FEATURED.print();

               apiCaller.setApiCall(new FeaturedCall());


           } else if (input.equals(Inputs.CATEGORIES.get())) {

               Messeges.CATEGORIES.print();

               apiCaller.setApiCall(new CategoryCall());


           } else if (input.split(" ")[0].equals(Inputs.PLAYLISTS.get())) {

               String cName = Arrays.stream(input.split(" ")).skip(1).collect(Collectors.joining(" "));
               Messeges.PLAYLISTS.print(cName.toUpperCase());

                apiCaller.setApiCall(new PlaylistsCall(cName));
           }

           response = apiCaller.call();
           response.forEach(System.out::println);

       }

    }

    public void authorize() {
        Server authorizer = new Server();
        authorizer.createServer();
        authorizer.authRequest();
    }

}
