package Bit;

/*
given an array which has 3 of every number except 1 number which only occurs once, find this number
 */
class find3all1unique {
    static int find1Unique(int[] arr){
        int ones = 0;
        int twos = 0;
        int not_threes;
        for (int x : arr){
            twos |= ones & x;
            ones ^= x;
            not_threes = ~(ones & twos);
            ones &= not_threes;
            twos &= not_threes;
        }
        return ones;
    }
    public static void main(String[] args){
        int[] arr = new int[]{1, 3, 2, 4, 3, 1, 1, 2, 3, 2};//ans: 4
        System.out.println(find1Unique(arr));
    }
}
