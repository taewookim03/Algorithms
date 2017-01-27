package CTCI.p16moderate;

class p16_7_number_max {
    static int sign(int n){
        return n >>> 31;
    }
    static int flip(int n){
        return 1 ^ n;
    }
    static int max(int a, int b){
        //let k be a binary indicating that b is bigger (a-b is minus, so the sign bit is 1)
        //then max = a*~k + b*k
        int c = a - b;

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int k = (sa ^ sb)*sa + (flip(sa ^ sb))*(sc);
        return a*flip(k) + b*k;

        //OVERFLOW POSSIBLE FROM a - b when a > 0 && b < 0 or a < 0 && b > 0
//        int k = sign(a-b);//k = 1 if a < b, 0 otherwise
//        int notK = flip(k);//flip 0th bit
//        return a * notK + b * k;
    }
    public static void main(String[] args){
        System.out.println(max(3, 5));
        System.out.println(max(6, 4));
        System.out.println(max(11, 11));
        System.out.println(max(Integer.MAX_VALUE, -1));
    }

}
