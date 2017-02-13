package some_codility_challenge;

/**
 * Created by Taewoo Kim on 2/11/2017.
 * for an interview coding challenge
 */
public class q1 {
    static public int solution(String S) {
        // write your code in Java SE 8
        int n = S.length();


        int count = 0;
        int k = 0;//count since last uppercase

        //count until first uppercase found
        int i = 0;
        while(i < n && !Character.isUpperCase(S.charAt(i))){
            count++;
            i++;
        }
        if (i == n) return -1;
        int maxCount = count;

        while (i < n){
            char c = S.charAt(i++);

            if (Character.isDigit(c)){
                if (count > maxCount) maxCount = count;
                count = 0;
                k = 0;
            }
            else if (Character.isUpperCase(c)){
                if (count > maxCount) maxCount = count;
                count = k + 1;
                k = 0;
            }
            else{
                //lower case
                count++;
                k++;
            }
        }
        if (count > maxCount) maxCount = count;

        return maxCount;
    }
    public static void main(String[] args){
        System.out.println(solution("abcDab0abcD"));
    }
}
