package DynamicProgramming;

/**
 * Created by Taewoo Kim on 2/14/2017.
 */
public class min_edit_palindrome {
    static int minEditPalindrome(String s){
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] dist = new int[n+1][n+1];
        for (int j = 0; j <= n; j++){
            dist[0][j] = j;
        }
        for (int i = 1; i <= n; i++){
            dist[i][0] = i;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                int ins = 1 + dist[i-1][j];
                int del = 1 + dist[i][j-1];
                int replace = dist[i-1][j-1] + (s.charAt(i-1) == r.charAt(j-1) ? 0 : 1);
                dist[i][j] = Math.min(ins, Math.min(del, replace));
            }
        }
        return dist[n][n]/2;
    }
    public static void main(String[] args){
        String[] inputs = new String[]{
                "aba",//0
                "abba",//0
                "bba",//1
                "bbba",//1
                "tanbirahmed",//5
                "shahriarmanzoor",//7
                "monirulhasan",//6
                "syedmonowarhossain",//8
                "sadrulhabibchowdhury",//8
                "mohammadsajjadhossain"//8
        };

        for (String s : inputs){
            System.out.println(minEditPalindrome(s));
        }
    }
}
