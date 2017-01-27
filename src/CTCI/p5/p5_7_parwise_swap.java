package CTCI.p5;

class p5_7_parwise_swap {
    static int pairSwap(int n){
        //swap bit 0/1, 2/3, 4/5, etc.
        int evens = 0xAAAAAAAA & n;
        int odds = 0x55555555 & n;
        int result = (evens >> 1) | (odds << 1);
        return result;
    }
    public static void main(String[] args){
        int a = 0b100110010101;
        System.out.println(Integer.toBinaryString(pairSwap(a)));
    }
}
