package DynamicProgramming;

/**
 * Created by Taewoo Kim on 2/6/2017.
 * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 */
public class count_possible_decodings_of_digits {
    static int numDecodings2(String digits){
        //realize that recursive calls only look one way, so we can just build an array (O(n))
        //this can be done going backwards or forwards (look at the back and recursive going backward)
        //count the number of ways to decode for string up to ith char [0 .. i-1]
        int n = digits.length();
        int[] count = new int[n+1];
        count[0] = 1;//1 possible decoding for empty string
        count[1] = 1;//1 possible decoding for 1 letter

        for (int i = 2; i <= n; i++){
            count[i] = 0;
            //if digit isn't 0, can use all possible combinations int [0, i-1]
            if (digits.charAt(i-1) > '0') count[i] += count[i-1];
            if ((digits.charAt(i-2) == '1') ||
                    (digits.charAt(i-2) == '2' && digits.charAt(i-1) <= '6')) count[i] += count[i-2];
        }
        return count[n];
    }

    static int numDecodings(String digits){
        return numDecodingsUtil(digits, 0, new int[digits.length()]);
    }
    static int numDecodingsUtil(String digits, int i, int[] memoCounts){
        //base case - no more digits to consider, only 1 way to decode
        if (i == digits.length()) return 1;
        if (memoCounts[i] != 0) return memoCounts[i];

        int use1digit = 0;
        if (digits.charAt(i) > '0') use1digit = numDecodingsUtil(digits, i+1, memoCounts);
        int use2digit = 0;
        if (i + 1 < digits.length() && digits.charAt(i) > '0' && Integer.parseInt(digits.substring(i, i+2)) <= 26){
            use2digit = numDecodingsUtil(digits, i+2, memoCounts);
        }
        return use1digit + use2digit;
    }

    public static void main(String[] args){
        //String digits = "121";//3
        //String digits = "1234";//3
        String digits = "1203";//1
        System.out.println(numDecodings2(digits));
    }
}
