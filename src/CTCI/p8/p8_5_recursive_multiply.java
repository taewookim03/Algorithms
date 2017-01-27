package CTCI.p8;

class p8_5_recursive_multiply {
    static int recMul(int a, int b){
        if (b == 1) return a;
        if (a == 0 || b == 0) return 0;
        if (b > a) return recMul(b, a);
        if ((b & 1) == 1) return a + recMul(a, b-1);

        return recMul(a << 1, b >> 1);
    }

    public static void main(String[] args){
        System.out.println(recMul(5, 16));
    }
}
