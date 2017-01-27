package CTCI.p5;

class p5_6_conversion {
    static int conversion(int a, int b){
        //get number of bits that need to be flipped to convert a to b
        int count = 0;

        a ^= b;
//        while (a > 0){
//            count += a & 1;
//            a >>>= 1;
//        }

        //more efficient loop:
        while (a != 0){
            count++;
            a = a & (a - 1);//clear least significant bit (counting cardinality)
        }
        return count;
    }
    public static void main(String[] args){
        int a = 0b11101;
        int b = 0b01111;
        System.out.println(conversion(a, b));//2 bits must be flipped
    }
}
