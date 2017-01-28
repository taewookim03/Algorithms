package Other;

public class PrimaryArithmetic10035 {
}
/*
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b;
        //get first input
        a = scan.nextInt();
        b = scan.nextInt();

        while (!(a == 0 && b == 0)) {
            //calculate carry
            int n = a;
            int m = b;
            int numCarry = 0;
            int carry = 0;
            while (n != 0 || m != 0){
                int p = n % 10;
                int q = m % 10;
                if (p + q + carry >= 10){
                    carry = 1;
                    numCarry++;
                }
                else carry = 0;

                //update
                n /= 10;
                m /= 10;
            }


            //output
            if (numCarry == 0) {
                System.out.println("No carry operation.");
            }
            else {
                System.out.print(numCarry + " carry operation");
                if (numCarry > 1) System.out.print('s');
                System.out.println('.');
            }
            //get next input
            a = scan.nextInt();
            b = scan.nextInt();
        }
    }
}

 */