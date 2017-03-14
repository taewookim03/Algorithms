package Arrays;

/**
 * Created by Taewoo Kim on 3/4/2017.
 */
public class threeSumSmaller
{
    /*

3sum
that satisfy the condition nums[i] + nums[j] + nums[k] = target.

3sum smaller
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

[-2, 0, 1, 3]
        i  j
 k

count 2
sum 2
6

[-3,-2,1,2,7,8]
       i     j
    k

count 6
target 6

Return 2. Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]


*/

    public static int threeSumLess(int[] arr, int target){
        int count = 0;
        int n = arr.length;
        //Arrays.sort(arr);

        for(int k = 0; k < n; k++){
            int i = k+1;
            int j = n-1;
            while (i < j){
                int sum = arr[k] + arr[i] + arr[j];
                if (sum < target){
                    count += j-i;
                    i++;
                }
                else{
                    j--;
                }
            }
        }

        return count;
    }
}
