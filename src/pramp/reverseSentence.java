package pramp;

public class reverseSentence {
    static void reverseSentence(char[] sentence){
        int n = sentence.length;
        reverseWord(sentence, 0, n-1);
        int left = 0;
        for (int i = 0; i <= n; i++){
            if (i == n || Character.isWhitespace(sentence[i])){//this is the end of the word
                reverseWord(sentence, left, i-1);
                left = i+1;
            }
        }
    }
    static void reverseWord(char[] sentence, int i, int j){
        while (i < j){
            char temp = sentence[i];
            sentence[i] = sentence[j];
            sentence[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        String[] input = new String[]{
                "practice makes perfect",
                "",
                "   ",
                "practice",
                "practice makes    perfect"
        };

        for (String s : input){
            char[] arr = s.toCharArray();
            reverseSentence(arr);
            System.out.println(String.valueOf(arr));
        }
    }
}
