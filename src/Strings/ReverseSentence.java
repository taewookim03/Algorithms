package Strings;

import java.util.Collections;

class ReverseSentence{
    static String reverseSentence(String sentence){
        //naive O(n) time, O(n) space
//        String[] arr = sentence.split(" ");
//        for (int i = 0; i < arr.length / 2; i++){
//            String temp = arr[i];
//            arr[i] = arr[arr.length - 1 - i];
//            arr[arr.length - 1 - i] = temp;
//        }
//
//        String r = "";
//        boolean first = true;
//        for (String word : arr){
//            if (first) first = false;
//            else r += " ";
//            r += word;
//        }

        //better O(n) time, O(1) space (ONLY IF I WASN'T USING JAVA - damn immutable strings)
        //reverse whole string, then reverse chars in each word
        char[] arr = sentence.toCharArray();
        for (int i = 0; i < arr.length / 2; i++){
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        int start = 0;//end = i
        for (int i = 0; i <= arr.length; i++){
            if (i == arr.length || arr[i] == ' '){
                int word_length = i - start;
                for (int j = 0; j < word_length / 2; j++){
                    char temp = arr[start + j];
                    arr[start + j] = arr[start + word_length - 1 - j];
                    arr[start + word_length - 1 - j] = temp;
                }
                start = i + 1;
            }
        }


        return String.valueOf(arr);
    }

    public static void main(String[] args){
        String s = "My name is Chris";
        System.out.println(s);
        System.out.println(reverseSentence(s));
    }
}