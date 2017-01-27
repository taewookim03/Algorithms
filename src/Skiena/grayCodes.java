package Skiena;

class GrayToBinaryConversion {
    public static final int N = 4;

    public static void main(String args[]) {
        for(int i=0; i<Math.pow(2,N); i++) {
            System.out.println(lpad(Integer.toBinaryString(i ^ i>>1)));
        }
    }

    //Optional method for left padding by 0's
    public static String lpad(String input) {
        StringBuffer output = new StringBuffer(N);
    //Pad output string with 0's
        for(int i=0; i<N-input.length(); i++) {
            output.append('0');
        }
    //Append input string
        return output.append(input).toString();
    }
}