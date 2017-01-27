package CTCI.p5;

class p5_3_flip_bit_to_win {
    static int flipLongest1s(int n){
        String binary = Integer.toBinaryString(n);
        int i = 0;
        int left = 0;
        int right = 0;

        //count 1s from left
        while (binary.charAt(i) != '0'){
            i++;
            left++;
        }
        int max = left;

        while (i < binary.length()){
            //count number of consecutive 1s to the right of 0 found
            i++;
            while(i < binary.length() && binary.charAt(i) != '0'){
                i++;
                right++;
            }
            if (left + right + 1 > max) max = left + right + 1;
            left = right;
            right = 0;
        }
        return max;
    }

    //O(1) space instead of O(n)
    static int flipBit(int n){

        int left = 0;
        int right = 0;
        //count 1s from right
        while ((n & 1) == 1){
            right++;
            n >>>= 1;//shift n right
        }
        int max = right;
        n >>>= 1;

        while (n != 0){
            while ((n & 1) == 1){
                left++;
                n >>>= 1;
            }
            if (right + left + 1 > max) max = right + left + 1;
            right = left;
            left = 0;
            n >>>= 1;
        }

        return max;
    }

    //simpler
    static int flipBit2(int n){
        int prev = -1;//to take care of edge case when all 1s (-1)
        int current = 0;
        int max = 1;

        while (n != 0){
            if ((n & 1) == 1){//bit is 1
                current++;
            }
            else{//bit is 0
                prev = current;
                current = 0;
            }
            max = Math.max(prev + current + 1, max);
            n >>>= 1;
        }
        return max;
    }

    public static void main(String[] args){
        int input = 0b11011101111;//result: 8 (flip bit 4)
        System.out.println(flipLongest1s(input));
        System.out.println(flipBit(input));
        System.out.println(flipBit2(input));
    }
}
