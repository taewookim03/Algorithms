package CTCI.p16moderate;

import java.util.HashMap;
import java.util.Map;

class p16_5_factorial_zeros {
//    private static class Counts{
//        int count2;
//        int count5;
//        Counts(int count2, int count5){
//            this.count2 = count2;
//            this.count5 = count5;
//        }
//    }
    static int factorialZeros(int n){
        //Counts[] memo = new Counts[n+1];
        //int twos = 0;
        if (n < 0) return -1;

        int[] memo = new int[n+1];//number of 5 factors
        for (int i = 0; i <= n; i++){
            memo[i] = -1;
        }

        int fives = 0;

        for (int i = 2; i <= n; i++){
            int temp = i;
            int count5 = 0;
            while (temp % 5 == 0){
                if (memo[temp] != -1){
                    count5 += memo[temp];
                    break;
                }
                else{
                    temp /= 5;
                    count5++;
                }
            }
            memo[i] = count5;
            fives += memo[i];
        }
        return fives;
    }
    public static void main(String[] args){
        System.out.println(factorialZeros(10));//ans=2
        System.out.println(factorialZeros(12));//ans=2
        System.out.println(factorialZeros(20));
    }
}
