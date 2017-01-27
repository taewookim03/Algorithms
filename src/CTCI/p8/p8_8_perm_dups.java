package CTCI.p8;

import java.util.Arrays;

class p8_8_perm_dups {
    static void permDups(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        perm(String.valueOf(arr), "");
    }
    static void perm(String str, String sub){
        if (str.isEmpty()) {
            System.out.println(sub);
            return;
        }

        for (int i = 0; i < str.length(); i++){
            if (i != 0 && str.charAt(i) == str.charAt(i-1)){
                continue;
            }
            perm(str.substring(0, i) + str.substring(i+1), sub + str.charAt(i));
        }
    }

    public static void main(String[] args){
        permDups("ABCC");
    }
}
