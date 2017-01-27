package CTCI.p1;

class p1_4_palindromePerm {
    static boolean palinPerm(String str){
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");

        int[] charCount = new int[128];//assuming ASCII
        for (int i = 0; i < str.length(); i++){
            charCount[str.charAt(i)]++;
        }

        int odds = 0;
        for (int count : charCount){
            if (count % 2 != 0){
                odds++;
                if (odds > 1) return false;
            }
        }
        return true;

        //also can use bitset (or just int if assuming 26 characters) and count number of set bits
        //odd = set, even = not set so if cardinaltiy() <= 1 return true. can check with a & a-1 on int

    }
    public static void main(String[] args){
        System.out.println(palinPerm("Tact Coa"));
        System.out.println(('a' + 1));
    }
}
