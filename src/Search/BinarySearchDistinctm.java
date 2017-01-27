package Search;

/**
 * in a sorted array of size n containing some of the elements from the set 1 .. m where n < m,
 * find the smallest integer <= m that is not in a in O(lgn)
 */
class BinarySearchDistinctm {
    static int findMissing(int[] arr){
        //1st element
        if (arr[0] != 1) return 1;

        //not missing in array
        if (arr[arr.length-1] == arr.length) return arr.length+1;

        return findGap(arr, 0, arr.length-1);
    }
    static int findGap(int[] arr, int lo, int hi){
        //base case 2 integers
        if (hi == lo + 1){
            return arr[lo] + 1;
        }

        int mid = lo + (hi - lo)/2;
        //finding smallest gap to the left
        if (arr[mid] - arr[lo] > mid - lo){
            return findGap(arr, lo, mid);
        }
        else return findGap(arr, mid, hi);

    }

    public static void main(String[] args){
        int[] a = new int[]{1, 2, 3, 5, 8, 9};
        //m = 8
        //answer = 3
        System.out.println(findMissing(a));
    }
}
