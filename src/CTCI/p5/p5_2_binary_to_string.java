package CTCI.p5;

class p5_2_binary_to_string {
    static String floatBinary(double n){
        if (n >= 1 || n <= 0) return "ERROR";

        StringBuilder sb = new StringBuilder(".");
        while (n != 0){
            n *= 2;
            if (n >= 1){
                sb.append(1);
                n -= 1;
            }
            else{
                sb.append(0);
            }

            if (sb.length() >= 32) return "ERROR";
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(floatBinary(0.390625));

    }
}
