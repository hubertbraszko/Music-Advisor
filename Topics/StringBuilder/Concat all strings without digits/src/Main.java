import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for(var s : strings){

            sb.append(s.replaceAll("[0-9]",""));
        }
//        for(int i=0; i < sb.length();i++){
//            if(Character.isDigit(sb.charAt(i))){
//                sb.deleteCharAt(i);
//            }
//        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}