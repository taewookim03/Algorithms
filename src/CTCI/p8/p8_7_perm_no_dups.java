package CTCI.p8;

class p8_7_perm_no_dups {
    static void permNoDups(String s){
        perm(s, "");
    }
    static void perm(String str, String sub){
        if (str.isEmpty()){
            System.out.println(sub);
            return;
        }
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            perm(str.substring(0, i) + str.substring(i+1), sub + c);
        }
    }

    public static void main(String[] args){
        permNoDups("ABC");
    }
}
