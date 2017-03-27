package DynamicProgramming;

class LongestIncreasingSequence {
    //nlogn solution - http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    //set of lists apporach - can use array if only the length of the LIS is queried. O(nlogn)

    //binary search to find the index of the largest element that is smaller than the value
    static int largestSmallerIndex(int[] ends, int left, int right, int val){
        while(left <= right){
            int mid = (left+right)/2;
            if (ends[mid] < val){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return right;
    }

    static int LISnlogn(int[] arr){
        int n = arr.length;
        int[] ends = new int[n];
        ends[0] = arr[0];
        int len = 1;//length of the ends array

        for (int i = 1; i < n; i++){
            if (arr[i] < ends[0]){
                ends[0] = arr[i];
            }
            else if (arr[i] > ends[len - 1]){
                ends[len++] = arr[i];
            }
            else{
                ends[largestSmallerIndex(ends, 0, len-1, arr[i]) + 1] = arr[i];
            }
        }
        return len;
    }

    //O(n^2) but apparently dictionary can make it O(nlogn)?
    static String LIS(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];
        int[] prev = new int[n];

        lis[0] = 1;
        prev[0] = -1;

        int max_LIS_length = 1;
        int max_LIS_end = 0;


        for (int i = 1; i < n; i++){
            int max_LIS = 1;
            int max_LIS_i = -1;
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[i] && lis[j] + 1 > max_LIS){
                    max_LIS = lis[j] + 1;
                    max_LIS_i = j;
                }
            }

            lis[i] = max_LIS;
            prev[i] = max_LIS_i;

            //update over max LIS to track it
            if (max_LIS > max_LIS_length){
                max_LIS_length = max_LIS;
                max_LIS_end = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int pre = max_LIS_end;
        while (pre != -1){
            sb.insert(0, arr[pre] + " ");
            pre = prev[pre];
        }
        return sb.toString();
    }

    public static void main(String[] args){
        int[] arr = new int[]{2, 6, 3, 4, 1, 2, 9, 5, 8};
        int[] arr1 = new int[]{3, 10, 2, 1, 20};
        int[] arr2 = new int[]{3, 2};
        int[] arr3 = new int[]{50, 3, 10, 7, 40, 80};

        System.out.println(LIS(arr));
        System.out.println(LISnlogn(arr));
        System.out.println(LISnlogn(arr1));
        System.out.println(LISnlogn(arr2));
        System.out.println(LISnlogn(arr3));
    }
}
