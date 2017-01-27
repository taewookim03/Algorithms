package CTCI.p5;

class p5_1_insertion {
    public static void main(String[] main){
        int n = 0b10000000000;
        //int n = 0b11111111111;
        int m = 0b10011;
        int j = 6;//from right
        int i = 2;//from right
        //we want result to be 0b10001001100
        //get 111110000011, AND with n (to clear j through i), then OR with m << i
        int mask = -1;
        mask <<= j + 1;
        mask |= ((1 << i) - 1);
        System.out.println(Integer.toBinaryString((n & mask) | (m << i)));
    }
}
