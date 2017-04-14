package Combinatorics;

class BacktrackPermutations {
    static String swap(String str, int i, int j){
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }

    static void perm(String str, int k){
        //base case: if substring length is the same as original
        if (str.length() == k){
            System.out.println(str);
        }

        for (int i = k; i < str.length(); i++){
            //swap char between i and k, but backtrack not necessary since java strings are immutable
            if (i != k && str.charAt(i) == str.charAt(k)) continue;//avoid duplicates
            str = swap(str, i, k);
            perm(str, k + 1);
        }

    }

    public static void main(String[] args){
        String s = "ABB";
        perm(s, 0);
    }
}
