package Strings;

/**
 * Created by Taewoo Kim on 2/3/2017.
 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 *
 * given strings txt and pattern, find all pattern's anagrams in the txt
 */
public class anagram_substring_search {

    //O(n) expected modified Rabin-Karp but O(mn) worst (check at every index with bad/unlucky hash)
    //O(n) if assuming 256 chars and checking with frequency count array (possible since anagrams not a particular pattern)
    static void searchAnagrams(String txt, String pattern){
        int[] patternCounts = new int[256];
        int[] currentCounts = new int[256];

        for (int i = 0; i < pattern.length(); i++){
            patternCounts[pattern.charAt(i)]++;
            currentCounts[txt.charAt(i)]++;
        }

        for (int i = 0; i < txt.length() - pattern.length(); i++){
            if (equalCounts(currentCounts, patternCounts)) System.out.println(i);
            currentCounts[txt.charAt(i)]--;
            currentCounts[txt.charAt(i + pattern.length())]++;
        }
        if (equalCounts(currentCounts, patternCounts)) System.out.println(txt.length() - pattern.length());
    }
    static boolean equalCounts(int[] current, int[] pattern){
        for (int i = 0; i < current.length; i++){
            if (current[i] != pattern[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        String txt = "BACDGABCDA";
        String pattern = "ABCD";
        //at 0, 5, 6
        searchAnagrams(txt, pattern);
    }
}
