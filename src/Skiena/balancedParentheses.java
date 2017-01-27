//public class balancedParentheses {
//}
//
//import java.util.Scanner;
//
//public class Main {
//    public static boolean balancedP(String str){
//        //keep track of number of open and closed paren - open: +1, close: -1, if sum goes below 0, invalid
//        int count = 0;
//
//        for (int i = 0; i < str.length(); i++){
//            char c = str.charAt(i);
//            if (c == '('){
//                count++;
//            }
//            else{
//                count--;
//            }
//            if (count < 0){
//                System.out.println("Offending pos: " + i);
//                return false;
//            }
//        }
//        if (count == 0){
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while (scan.hasNext()){
//            String str = scan.next();
//            System.out.println(balancedP(str));
//        }
//    }
//}
//
//