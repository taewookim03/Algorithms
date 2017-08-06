package Search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a sorted array of numbers, write a function to find how many times x occurs in it.
 */
public class count_x_sorted_array {
    public static void main(String[] args) {
        int[] array = {-4, -2, -2, 0, 1, 2, 2, 2, 3, 4, 4};//11

        for (int num : Arrays.stream(array).boxed().distinct().collect(Collectors.toList())) {
            System.out.println(num + ": " + countX(array, num));
        }
        System.out.println(countX(array, -3));
    }

    static int countX(int[] arr, int x){
        //search inclusive range
        //search for left border

        //if >= x, search left

        int n = arr.length;
        if (n == 0) return 0;

        int left = 0;
        int right = n-1;
        int mid = 0;//compiler might complain if not initialized
        while (left <= right){
            mid = (left+right)/2;
            //check if mid meets condition
            if (arr[mid] == x && (mid == 0 || arr[mid-1] != x)){
                break;
            }
            else if (arr[mid] >= x){
                //recurse left
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if (arr[mid] != x) return 0;
        int start = mid;

        left = 0;
        right = n-1;
        while (left <= right){
            mid = (left+right)/2;
            if (arr[mid] == x && (mid == n-1 || arr[mid+1] != x)){
                break;
            }
            else if (arr[mid] <= x){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        int end = mid;

        return end - start + 1;
    }
}
