package some_hr_challenge;
import java.io.IOException;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/8/2017.
 * for an interview coding challenge
 * given an array of positive numbers, find the minimum sum of the array such that all elements are unique.
 * elements may only be increased (once)
 */
public class p2 {
    static int getMinimumUniqueSum(int[] arr) {
        Arrays.sort(arr);
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] <= arr[i-1]) {
                arr[i] = arr[i - 1] + 1;
            }
            sum += arr[i];
        }
        return sum;
    }

    public static void main (String[] args) throws IOException {
        System.out.println(getMinimumUniqueSum(new int[]{1,10, 10, 10}));
    }
}
