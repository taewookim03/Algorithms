package CTCI.p5;

class p5_4_next_number {
    //bit manip
    static int prev(int n){
        if (n == 0) return 0;

        int temp = n;
        int c0 = 0, c1 = 0;
        //count 1s
        while ((temp & 1) == 1){
            c1++;
            temp >>= 1;
        }
        while((temp & 1) == 0){
            c0++;
            temp >>= 1;
        }

        c1++;//actual number of first 1s in next
        c0--;//same

        //arithmetic, completely based on next(n) function derived first
        n -= (1 << c0);
        n -= (1 << (c1 - 1)) - 1;

//        //flip (c0+c1)th bit
//        n ^= (1 << (c0 + c1));
//
//        //fill first c0+c1 bits
//        n |= ((1 << (c0 + c1)) - 1);
//
//        //mask c0 bits from right
//        n &= (-1 << c0);

        return n;
    }
    static int next(int n){
        if (n == 0) return 0;

        int temp = n;
        int c0 = 0, c1 = 0;
        //count c0 and c1 from left
        while ((temp & 1) == 0){
            c0++;
            temp >>= 1;
        }
        while ((temp & 1) == 1){
            c1++;
            temp >>= 1;
        }

//        //set (c0+c1)th bit, which is 0
//        n |= (1 << (c0+c1));
//
//        //mask first (c0+c1) bits
//        n &= (-1 << (c0+c1));
//
//        //set first (c1 - 1) bits
//        n |= ((1 << (c1 - 1)) - 1);

        //or arithmetically
        n += (1 << c0);//flip (c0+c1)th bit and set trailing bits to 0
        n += (1 << (c1 - 1)) - 1;//set first c1 - 1 bits from right to 1s

        return n;
    }

    public static void main(String[] args){
        int n = 0b0011100011;
        System.out.println(Integer.toBinaryString(prev(n)));
        System.out.println(Integer.toBinaryString(next(prev(n))));
        System.out.println(Integer.toBinaryString(next(n)));
    }
}
