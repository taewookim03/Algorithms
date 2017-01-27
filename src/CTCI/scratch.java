package CTCI;



class scratch {
    static boolean hasConsecSubstring(String input){
        return hasConsecSubUtil(input, "");
    }
    static boolean hasConsecSubUtil(String input, String check){
        if (input == null || input.equals("")) return false;
        if (check.length() > input.length()) return false;
        if (check.length() > 0 && check.equals(input.substring(0, check.length()))) return true;

        return (hasConsecSubUtil(input.substring(1), check + input.substring(0, 1))
                || hasConsecSubUtil(input.substring(1), input.substring(0,1)));
    }
    public static void main(String[] args){
        String[] data = new String[]{"a","aa","adabcabcd","abcabc","ab","abab","abcab","aa",
                "baba","aaabcabcaaa","password","power","abc"};
        for (String s : data){
            System.out.println(hasConsecSubstring(s));
        }
//        false
//        true
//        true
//        true
//        false
//        true
//        false
//        true
//        true
//        true
//        true
//        false
        //false
    }
}
