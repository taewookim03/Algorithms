class scracth{

    static int magicalString(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int lengthIndex = 1;
        while (sb.length() < n){
            if (sb.charAt(sb.length()-1) == '1'){
                sb.append('2');
            }
            else{
                sb.append('1');
            }

            if (sb.charAt(lengthIndex) == '2'){
                sb.append(sb.charAt(sb.length()-1));//extend length
            }
            lengthIndex++;
        }

        //check length and cut off last if needed
        if (sb.length() > n){
            sb.deleteCharAt(sb.length()-1);
        }

        System.out.println(sb.toString());
        return 1;
    }

    public static void main(String[] args){
        //perm("abc", "");
        magicalString(10);
    }
}
