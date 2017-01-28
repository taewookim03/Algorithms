class scracth{

    static int gcd(int a, int b){
        //base case
        if (b == 0) return a;
        //if (a%b == 0) return b;
        return gcd(b, a%b);
    }

    static void perm(String str, String prefix){
        if (str.isEmpty()){
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            perm(str.substring(0, i) + str.substring(i + 1), prefix + c);
        }
    }

    public static void main(String[] args){
        //perm("abc", "");
        System.out.println(-50 % 100);
    }
}
