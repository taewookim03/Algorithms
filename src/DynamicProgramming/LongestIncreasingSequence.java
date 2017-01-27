package DynamicProgramming;

//O(n^2) but apparently dictionary can make it O(nlogn)
class LongestIncreasingSequence {
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
            sb.insert(0, arr[pre]);
            pre = prev[pre];
        }
        return sb.toString();
    }

    public static void main(String[] args){
        int[] arr = new int[]{2, 6, 3, 4, 1, 2, 9, 5, 8};
        System.out.println(LIS(arr));

    }
}
