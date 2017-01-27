package CTCI.p1;

class p1_9_string_rotation {
    static boolean isSubstring(String sub, String str){
        if (sub.length() < 1) return true;

        //checks if sub is a substring of str
        for (int i = 0; i <= str.length() - sub.length(); i++){
            int j = i;//main string
            int k = 0;//substring
            while (sub.charAt(k) == str.charAt(j)){
                k++;
                j++;
                if (k == sub.length()) return true;
            }
        }
        return false;
    }

    static boolean strRotation(String s1, String s2){
        //use ONLY ONE CALL to isSubstring to check if s2 is a rotation of s1
        return isSubstring(s2, s1 + s1);
    }

    public static void main(String[] args){
        System.out.println(strRotation("waterbottle", "erbottlewat"));//true
    }
}
