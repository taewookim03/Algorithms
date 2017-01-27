package Arrays;

class MaxContiguousSubarray {
    static void maxSubSum(int[] arr){
        //find subarray [i .. j] such that its sum is maximum in the array
        int min_sum = Integer.MAX_VALUE;
        int i = -1;//index of min sum [0 .. i]

        int max_sum = Integer.MIN_VALUE;
        int j = -1;//index of max sum [0 .. j];

        int current_sum = 0;
        for (int k = 0; k < arr.length; k++){
            current_sum += arr[k];
            if (current_sum < min_sum){
                min_sum = current_sum;
                i = k + 1;
            }
            if (current_sum > max_sum){
                max_sum = current_sum;
                j = k;
            }
        }

        System.out.println(i + " to " + j + ", sum: " + (max_sum - min_sum));
    }

    public static void main(String[] args){
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        maxSubSum(arr);//ans: 7

        int[] arr2 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubSum(arr2);//ans: 6
    }
}
