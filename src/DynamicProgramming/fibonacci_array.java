package DynamicProgramming;

/**
 * Created by Taewoo Kim on 2/7/2017.
 */
public class fibonacci_array {
    static int[] fibUntil(int n){
        if (n < 0) return null;
        if (n == 0) return new int[0];

        int[] fibs = new int[n];
        fibs[0] = 1;
        if (n > 1) fibs[1] = 1;
        for (int i = 2; i < n; i++){
            fibs[i] = fibs[i-1] + fibs[i-2];
        }
        return fibs;
    }
    public static void main(String[] args){
        int[] arr = fibUntil(10);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
