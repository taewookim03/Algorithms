package some_codility_challenge;

/**
 * Created by Taewoo Kim on 2/11/2017.
 * for an interview coding challenge
 */
import java.util.*;

public class q2 {
    static public int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8

        int i = 0;
        int n = A.length;//number of people
        int stops = 0;
        while (i < n){
            int w = 0;//weight in elevator
            int p = 0;//num of people in elevator
            Set<Integer> floors = new HashSet<>();

            //add until full
            while (i < n && w+A[i] <= Y && p+1 <= X){
                //add person to elevator
                w += A[i];
                floors.add(B[i]);
                p++;
                i++;
            }

            //count number of stops
            stops += floors.size() + 1;//count going back to 0
        }
        return stops;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{40,40,100,80,20}, new int[]{3,3,2,2,3}, 3, 5, 200));
    }
}
