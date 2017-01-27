package Skiena;

class BacktrackSubsets {

    static void subsets(String str, String sub, int k){
        if (k == str.length()){
            if (sub.length() == 0){
                System.out.println("(empty)");
            }
            else{
                System.out.println(sub);
            }
            return;
        }

        //candidates - include next char (str.charAt(k)) or not
        //backtrack
        //include kth char
        subsets(str, sub + str.charAt(k), k + 1);

        //don't include kth char
        subsets(str, sub, k + 1);
    }

    public static void main(String[] args){
        String s = "123";
        subsets(s, "", 0);
    }
}
