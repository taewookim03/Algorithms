package CTCI.p8;


import java.util.ArrayList;
import java.util.List;

class p8_9_parens {
    //print all valid combinations of n pairs of parentheses
    //ex
    //input=3
    //output: ((())), (()()), (())(), ()(()), ()()()

    static void printParens(int n){
        List<String> list = new ArrayList<>();
        parens(n, n, "", list);
        for (String s : list){
            System.out.println(s);
        }
    }
    static void parens(int open, int close, String str, List<String> list){
        if (close == 0) {
            list.add(str);
            return;
        }
        if (open > 0){
            parens(open - 1, close, str+'(', list);
        }
        if (close > open){
            parens(open, close-1, str+')', list);
        }
    }


    public static void main(String[] args){
        printParens(3);
    }
}
