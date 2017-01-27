package Search;

/**
 * Created by Taewoo Kim on 1/7/2017.
 */
class BinarySearchShiftedArr {
    static int max(int[] arr){
        //do a binary search for an element that decreases in the next element, which is the maximum
        if (arr.length < 1) return -1;
        if (arr.length == 1) return arr[0];
        if (arr[0] < arr[arr.length - 1]) return arr[arr.length-1];

        int low = 0;
        int hi = arr.length - 1;
        int max = -1;

        while (low < hi){
            int mid = low + (hi - low)/2;
            if (arr[mid] < arr[hi]){
                //then search left
                if (arr[mid - 1] > arr[mid]) {
                    max = arr[mid-1];
                    break;
                }
                else{
                    hi = mid - 1;
                }
            }
            else{
                //search right
                if (arr[mid] > arr[mid + 1]){
                    max = arr[mid];
                    break;
                }
                else{
                    low = mid + 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = new int[]{3, 42, 1 };
        System.out.println(max(arr));
    }
}
