package advisor;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {

        if(args.length > 1 && args[0].equals("-access")){
            Config.SERVER_PATH.set(args[1]);
        }

        UserTextInterface menu = new UserTextInterface();
       // Server AppServer = Server.getServer();

        while(true){

            menu.start();

        }

    }
}
