import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int sumbegin =0;
        int sumend = 0;
        for(int i =0 ; i < input.length();i++){
            if(i < input.length()/2){sumbegin = Character.getNumericValue(input.charAt(i)) + sumbegin;}
            else{sumend=sumend+Character.getNumericValue(input.charAt(i));}
        }
        if(sumend==sumbegin){
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}