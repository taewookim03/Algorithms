package CTCI.p1;

class p1_3_URLify {
    static String urlify(String str){
//        str = str.trim();
//        str = str.replaceAll(" ", "%20");
//        return str;

        //using charArray
        char[] arr = str.toCharArray();

        //trim trail/lead whitespaces
        int i = 0;//beginning of string after trimming leading whitespaces
        int j = arr.length - 1;//end of string (inclusive)
        while (arr[i] == ' ') i++;
        while (arr[j] == ' ') j--;

        //count the number of spaces between i and j
        int space_count = 0;
        for (int k = i; k <= j; k++){
            if (arr[k] == ' ') space_count++;
        }

        int finalCount = j - i + 1 + 2 * space_count;
        char[] out = new char[finalCount];


        int o = 0;//out pointer
        for (int in = i; in <= j; in++){
            if (arr[in] == ' '){
                out[o] = '%';
                out[o+1] = '2';
                out[o+2] = '0';
                o += 3;
            }
            else{
                out[o++] = arr[in];
            }
        }
        return String.valueOf(out);
    }

    public static void main(String[] args){
        System.out.println(urlify("Mr John Smith     ") + "(end)");
    }
}
