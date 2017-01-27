package CTCI.p10;

class p10_3_search_in_rotated_array {
    static int search(int[] arr, int val){
        return searchRec(arr, 0, arr.length-1, val);
    }
    static int searchRec(int[] arr, int lo, int hi, int val){
        if (lo > hi) return -1;//not found
        if (lo == hi){
            if (arr[lo] == val) return lo;
            else return -1;
        }

        int mid = (lo+hi)/2;
        if (arr[mid] == val) return mid;
        //check if left is normal
        if (arr[lo] < arr[mid]){
            if (arr[lo] == val) return lo;
            if (arr[lo] < val && val < arr[mid]){
                return searchRec(arr, lo+1, mid-1, val);
            }
            else{
                return searchRec(arr, mid+1, hi, val);
            }
        }
        //right normal
        else if (arr[mid] < arr[hi]){
            if (arr[hi] == val) return hi;
            if (arr[hi] > val && val > arr[mid]){
                return searchRec(arr, mid+1, hi-1, val);
            }
            else{
                return searchRec(arr, lo, mid-1, val);
            }
        }
        //repeated elements-if on both sides, this algorithm is O(n)
        else{
            int result = searchRec(arr, lo, mid-1, val);
            if (result == -1) return searchRec(arr, mid+1, hi, val);
            else return result;
        }

    }
    public static void main(String[] args){
        int[] arr = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] arr2 = new int[]{2, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2};
        System.out.println(search(arr, 5));//8
        System.out.println(search(arr2, 3));
    }
}
