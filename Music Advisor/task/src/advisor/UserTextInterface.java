package advisor;

import java.util.Scanner;

public class UserTextInterface {

    private Scanner scanner = new Scanner(System.in);
    private boolean authorized = false;


    public UserTextInterface() {

    }

    private String getInput() {
        return scanner.nextLine();
    }

    private String responseMessage;

    public void start() {

        String input = getInput();

        if (input.equals(Inputs.EXIT.get())) {

            Messeges.EXIT.print();

            System.exit(0);

        } else if(!authorized) {

           if(input.equals(Inputs.AUTH.get()))
           {
               Messeges.AUTHLINK.print();
               authorized = true;
               Messeges.SUCCESS.print();
           }
           else {
               Messeges.UNAUTHORIZED.print();
           }
           
       } else {

           if(input.equals(Inputs.NEW.get())){

               Messeges.NEW_RELEASES.print();

               responseMessage = "Mountains [Sia, Diplo, Labrinth]\n" +
                       "Runaway [Lil Peep]\n" +
                       "The Greatest Show [Panic! At The Disco]\n" +
                       "All Out Life [Slipknot]";

               System.out.println(responseMessage);

           } else if (input.equals(Inputs.FEATURED.get())) {

               Messeges.FEATURED.print();

               responseMessage = "Mellow Morning\n" +
                       "Wake Up and Smell the Coffee\n" +
                       "Monday Motivation\n" +
                       "Songs to Sing in the Shower";

               System.out.println(responseMessage);

           } else if (input.equals(Inputs.CATEGORIES.get())) {

               Messeges.CATEGORIES.print();

               responseMessage = "Top Lists\n" +
                       "Pop\n" +
                       "Mood\n" +
                       "Latin";

               System.out.println(responseMessage);

           } else if (input.split(" ")[0].equals(Inputs.PLAYLISTS.get())) {

               Messeges.PLAYLISTS.print(input.split(" ")[1].toUpperCase());

               responseMessage = "Walk Like A Badass  \n" +
                       "Rage Beats  \n" +
                       "Arab Mood Booster  \n" +
                       "Sunday Stroll";

               System.out.println(responseMessage);

           }
       }

    }


}
