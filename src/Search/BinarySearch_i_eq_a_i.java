package Search;
/**
 * find element such that i = arr[i]
 */
class BinarySearch_i_eq_a_i {
    static int find_i(int[] arr, int lo, int hi){
        if (hi - lo < 0) return -1;

        int mid = lo + (hi - lo)/2;

        if (mid == arr[mid]) return mid;
        else if (mid < arr[mid]){
            return find_i(arr, lo, mid-1);
        }
        else return find_i(arr, mid+1, hi);
    }

    public static void main(String[] args){
        int[] arr1 = {-10, -3, 2, 5, 7};
        int[] arr2 = {2, 3, 4, 5, 6, 7};
        System.out.println(find_i(arr1, 0, arr1.length) + " " + find_i(arr2, 0, arr2.length));
    }
}
