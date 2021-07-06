import java.awt.*;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input=scanner.nextLine().split(" ");
        int Index=0;
        int biggestLength = 0;
        for(int i = 0; i < input.length; i ++){
            if(input[i].length()>biggestLength){Index=i; biggestLength=input[i].length();}
        }
        System.out.println(input[Index]);

    }
}