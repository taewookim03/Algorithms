package Skiena;

class PhoneNumberToLetters {
//    static Map<Integer, String> map = createMap();
//    static Map<Integer, String> createMap(){
//        Map<Integer, String> map = new HashMap<>();
//        map.put(2, "abc");
//        map.put(3, "def");
//        map.put(4, "ghi");
//
//        return map;
//    }

    static String[] map = new String[]{"", "", "abc", "def", "ghi", "etc."};

    static void printWords(int[] number){
        printWordsUtil(number, "", 0);
    }

    static void printWordsUtil(int[] number, String s, int k){
        //base case of the permutation
        if (k == number.length){
            System.out.print(s + " ");
            return;
        }

        String letters = map[number[k]];
        for (int i = 0; i < letters.length(); i++){
            printWordsUtil(number, s + letters.charAt(i), k + 1);
        }
    }

    public static void main(String[] args){
        int[] number = new int[]{2, 3, 4};

        printWords(number);
    }
}
