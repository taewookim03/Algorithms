package DynamicProgramming;

/**
 * Created by Taewoo Kim on 2/6/2017.
 * http://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
 * count all palindrome substrings larger than 1
 */
public class count_all_palindrome_substring {
    static int countPalindromeSubstrings(String s){
        int n = s.length();
        if (n <= 1) return 0;

        //base cases
        //if i == j true
        //if j = i+1 palindrome[i][j] = charAt(i) == charAt(j)
        //palindrome[i][j] = palindrome[i+1][j-1] && charAt(i) == charAt(j)
        //start from the top? bottom? (i = n-1, j = n-1) and fill going up
        int count = 0;
        boolean[][] palindrome = new boolean[n][n];
        for (int i = n-1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (i == j){
                    palindrome[i][j] = true;
                }
                else if (j == i+1){
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    palindrome[i][j] = palindrome[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                if (i != j && palindrome[i][j]) count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(countPalindromeSubstrings("abbab"));//3
        System.out.println(countPalindromeSubstrings("abbaeae"));//4
    }
}
