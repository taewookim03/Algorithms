package CTCI.p1;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

class p1_1_isUnique {
    //w/ data structure:
    static boolean isUnique(String str){
        //boolean[] charSet = new boolean[128];
        BitSet charSet = new BitSet(128);
        for (int i = 0; i < str.length(); i++){
            //if (charSet[str.charAt(i)]) return false;
            //charSet[str.charAt(i)] = true;
            if (charSet.get(str.charAt(i))) return false;
            charSet.set(str.charAt(i));
        }
        return true;
    }

    //w/o data structure
    //does charArray count as data structure? if not sort char array and compare adjacent elements, or use C++ for it
    //(assuming changing input string is ok)

    public static void main(String[] args){
        System.out.println(isUnique("abcad"));
    }
}
