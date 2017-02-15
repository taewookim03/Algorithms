import java.util.*;

class scratch{
    /*
    T(n) = n T(n-1) + O(n) (n = for loop, O(n) = substring)
    let G(n) = T(n)/n!
    G(n) = G(n-1) + O(1/(n-1)!)
    G(n) = O(1) ??
    T(n) = O(n!)
    + print
    T(n) = O(n*n!)
    */
    static void printPerms(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = String.valueOf(arr);
        printPermsUtil(s, "");
    }
    static void printPermsUtil(String s, String t){
        if (s.isEmpty()){
            System.out.println(t);
            return;
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (i != 0 && c == s.charAt(i-1)) continue;
            printPermsUtil(s.substring(0, i) + s.substring(i+1), t + c);
        }
    }

    static void printSubset(String s){
        printSubsetUtil(s, "", 0);
    }
    static void printSubsetUtil(String s, String build, int i){
        if (i == s.length()) {
            if (build.isEmpty()) System.out.println("(empty)");
            else System.out.println(build);
            return;
        }
        printSubsetUtil(s, build, i+1);
        printSubsetUtil(s, build + s.charAt(i), i+1);
    }
    public static void main(String[] args){
        String s = "ABC";
        String s2 = "ABCA";
        //printPerms(s2);
        printSubset(s);
    }
}
