package Combinatorics;

class BacktrackSubsets {
    //in order using bit
    static void subsetsOrdered(String str){
        int n = str.length();
        int numSubsets = 1 << n;

        for (int s = 0; s < numSubsets; s++){
            //read right to left and include in subset based on that
            for (int i = 0; i < n; i++){
                if ((s & (1 << i)) > 0){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }

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
        //subsets(s, "", 0);
        subsetsOrdered(s);
    }
}
