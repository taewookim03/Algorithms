package leetcode;
import java.util.*;

/**
 * Created by Taewoo Kim on 4/8/2017.
 */

public class word_ladder_ii {
    public class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> visited = new HashSet<>();
            Set<String> words = new HashSet<>(wordList);
            Set<String> currentLevel = new HashSet<>();
            currentLevel.add(beginWord);
            Map<String, List<String>> parent = new HashMap<>();

            boolean found = false;
            while (!currentLevel.isEmpty()){
                if (found) break;

                Set<String> temp = new HashSet<>();
                Set<String> preVisited = new HashSet<>();
                for (String word : currentLevel){
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++){
                        char original = chars[i];
                        for (char c = 'a'; c <= 'z'; c++){
                            chars[i] = c;
                            String candidate = String.valueOf(chars);
                            if (words.contains(candidate)){
                                if (candidate.equals(endWord)){
                                    found = true;
                                }
                                if (!visited.contains(candidate)){
                                    temp.add(candidate);
                                    preVisited.add(candidate);
                                    if (!parent.containsKey(candidate)) parent.put(candidate, new ArrayList<>());
                                    parent.get(candidate).add(word);
                                }
                            }
                        }
                        chars[i] = original;
                    }
                }
                currentLevel = temp;
                visited.addAll(preVisited);
            }
            List<List<String>> res = new ArrayList<>();
            if (found){
                parent.put(beginWord, null);
                res = getPaths(endWord, parent);
                for (List<String> list : res){
                    list.add(0, beginWord);
                }
            }
            return res;
        }

        private List<List<String>> getPaths(String word, Map<String, List<String>> parent){
            List<List<String>> res = new ArrayList<>();
            if (parent.get(word) == null){
                res.add(new ArrayList<String>());
                return res;
            }

            for (String p : parent.get(word)){
                List<List<String>> subRes = getPaths(p, parent);
                for (List<String> list : subRes){
                    list.add(word);
                    res.add(list);
                }
            }

            return res;
        }
    }

    public static void main(String[] args){
        word_ladder_ii.Solution s = new word_ladder_ii().new Solution();
        String[] arr = new String[]{"a","b","c"};
        List<List<String>> res = s.findLadders("a", "c", Arrays.asList(arr));
        for (List<String> list : res){
            for (String str : list){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
