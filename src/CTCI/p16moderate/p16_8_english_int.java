package CTCI.p16moderate;

import java.util.ArrayDeque;
import java.util.Deque;

class p16_8_english_int {
    static String[] upToTwenty = new String[] {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] tens = new String[]{
            "","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"
    };
    static String[] thousands = new String[]{
            "","thousand","million","billion"
    };

    static String engInt(int number){
        if (number < 0){
            return "negative " + engInt(-number);
        }

        Deque<String> chunks = new ArrayDeque<>();

        while (number > 0){
            chunks.addFirst(Integer.toString(number % 1000));
            number /= 1000;
        }

        String eng = "";
        int thousand = chunks.size() - 1;
        boolean first = true;
        for (String chunk : chunks){
            int i = Integer.parseInt(chunk);
            if (!first){
                eng += thousands[thousand--] + " " + engIntUtil(i);
            }
            else{
                first = false;
                eng += engIntUtil(i);
            }
        }
        return eng;
    }
    static String engIntUtil(int number){
        String eng = "";

        if (number >= 100){
            int hundreds = number/100;
            eng += upToTwenty[hundreds] + " hundred ";
        }
        if (number >= 10){
            int ten = number % 100;
            if (ten < 20){
                eng += upToTwenty[ten] + " ";
                return eng;
            }
            else{
                int t = ten/10;
                eng += tens[t] + " ";
            }
        }

        int ones = number % 10;
        eng += upToTwenty[ones] + " ";

        return eng;
    }

    public static void main(String[] args){
        System.out.println(engInt(56731234));
    }
}

