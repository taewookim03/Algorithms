package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class word_ladder {
    //2-way BFS
    public class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> beginLevel = new HashSet<>(), endLevel = new HashSet<>();
            int len = 1;
            Set<String> words = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();

            if (!words.contains(endWord)) return 0;

            beginLevel.add(beginWord);
            endLevel.add(endWord);
            visited.add(beginWord);//unnecessary
            visited.add(endWord);

            while (!beginLevel.isEmpty() && !endLevel.isEmpty()){
                //choose the skinnier graph (should on average alternate - 2-way BFS)
                if (beginLevel.size() > endLevel.size()){
                    Set<String> temp = beginLevel;
                    beginLevel = endLevel;
                    endLevel = temp;
                }

                Set<String> newLevel = new HashSet<>();
                for (String word : beginLevel){
                    //find neighbors
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++){
                        char original = chars[i];
                        for (char c = 'a'; c <= 'z'; c++){
                            chars[i] = c;
                            String newWord = String.valueOf(chars);

                            if (endLevel.contains(newWord)) return len + 1;
                            if (words.contains(newWord) && !visited.contains(newWord)){
                                newLevel.add(newWord);
                                visited.add(newWord);
                            }
                        }
                        chars[i] = original;
                    }
                }
                beginLevel = newLevel;
                len++;
            }

            return 0;
        }
    }

    //naive BFS
    public class Solution2 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> currentLevel = new HashSet<>();
            int len = 1;
            Set<String> words = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();
            currentLevel.add(beginWord);
            visited.add(beginWord);//unnecessary

            while (!currentLevel.isEmpty()){
                Set<String> newLevel = new HashSet<>();
                for (String word : currentLevel){
                    //find neighbors
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++){
                        char original = chars[i];
                        for (char c = 'a'; c <= 'z'; c++){
                            chars[i] = c;
                            String newWord = String.valueOf(chars);
                            if (words.contains(newWord) && !visited.contains(newWord)){
                                if (newWord.equals(endWord)) return len+1;
                                newLevel.add(newWord);
                                visited.add(newWord);
                            }
                        }
                        chars[i] = original;
                    }
                }
                currentLevel = newLevel;
                len++;
            }

            return 0;
        }
    }
}
