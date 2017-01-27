package CTCI.p1;

class p1_6_string_compression {
    static String compress(String str){
        if (str.length() <= 2) return str;

        StringBuilder compressed = new StringBuilder();
        char c = str.charAt(0);
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) != str.charAt(i+1)){
                compressed.append(c).append(count);
                c = str.charAt(i+1);
                count = 1;
            }
            else{
                count++;
            }
        }
        compressed.append(c).append(count);

        String cmp = compressed.toString();
        if (cmp.length() < str.length()) return cmp;
        return str;
    }

    public static void main(String[] args){
        System.out.println(compress("aabcccccaaa"));//a2b1c5a3
        System.out.println(compress("abcdabc"));//abcdabc
        System.out.println(compress("aabbaa"));//aabbaa NOT a2b2a2 (length is not shorter)
        System.out.println(compress("aabbcccd"));//aabbcccd NOT a2b2c3d1 (length same)

    }
}
