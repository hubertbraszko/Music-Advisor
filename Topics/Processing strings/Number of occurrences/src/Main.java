import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String sub =scanner.nextLine();
//        boolean contains = false;
//
//
//        for(int i = 0 ; i < input.length(); i++){
//            if(input.charAt(i)==sub.charAt(0)){
//                contains = true;
//                for(int j=0;j<sub.length();j++){
//                    if(input.charAt(j)!=sub.charAt(j)){
//                        contains = false;
//                    }
//
//                }
//            }
//
//
//        }

        String inputs[] = (" "+input+" ").split(sub);
        System.out.println(inputs.length-1);


    }
}