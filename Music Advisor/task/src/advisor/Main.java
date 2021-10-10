package advisor;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {

        if(args.length > 1 && args[0].equals("-access")){
            Config.SERVER_PATH.set(args[1]);
        }
        if(args.length > 3 && args[2].equals("-resource")){
            Config.API_SERVER.set(args[3]+"/v1/");
        }
        if(args.length > 5 && args[4].equals("-page")){
            Config.ITEMSPERPAGE.set(args[5]);
        }

        UserTextInterface menu = new UserTextInterface();


        while(true){

            menu.start();

        }

    }
}

