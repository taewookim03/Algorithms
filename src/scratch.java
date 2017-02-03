import java.util.*;

class scratch{
    static int bsIter(int[] arr, int val){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = (left+right)/2;
            if (arr[mid] == val) return mid;
            else if (arr[mid] < val){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    static int bsRec(int[] arr, int left, int right, int val){
        if (left > right) return -1;
        int mid = (left+right)/2;
        if (arr[mid] == val) return mid;
        else if (arr[mid] < val) return bsRec(arr, mid+1, right, val);
        else return bsRec(arr, left, mid-1, val);
    }

    public static void main(String[] args){
        int[] arr = new int[]{0,1,3,5,6,8,10,11,33};
        System.out.println(bsIter(arr, 5));
        System.out.println(bsRec(arr, 0, arr.length-1, 6));
    }
}
