package hackerrank;

/**
 * Created by Taewoo Kim on 2/10/2017.
 * this solution times out on larger cases. solution here:
 * https://www.hackerrank.com/contests/rookierank-2/challenges/prefix-neighbors/editorial
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class prefix_neighbors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.next();
        }

        System.out.println(maxBenefit(s));
    }

    static class TrieNode{
        char c;
        boolean end;
        Map<Character, TrieNode> children;
        TrieNode(char c){
            this.c = c;
            children = new HashMap<>();
        }
    }
    static class Trie{
        TrieNode root = new TrieNode('\0');
        Map<String, Integer> benefit = new HashMap<>();

        void insert(String s){
            TrieNode curr = root;
            int n = s.length();
            int b = 0;
            for (int i = 0; i < n; i++){
                char c = s.charAt(i);
                b += c;
                if (!curr.children.containsKey(c)){
                    curr.children.put(c, new TrieNode(c));
                }
                curr = curr.children.get(c);
            }
            curr.end = true;
            benefit.put(s, b);
        }

        String getSmallerPrefixNeighbor(String s){
            //search
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            StringBuilder buffer = new StringBuilder();

            int n = s.length();
            for (int i = 0; i < n; i++){
                char c = s.charAt(i);
                if (curr.end){
                    sb.append(buffer);
                    buffer = new StringBuilder();
                }
                buffer.append(c);
                curr = curr.children.get(c);
            }

            return sb.toString();
        }
    }

    static int maxBenefit(String[] strings){
        Trie tr = new Trie();
        //process all words into trie
        for (String s : strings){
            tr.insert(s);
        }

        //greedy
        Queue<String> maxHeap = new PriorityQueue<>((a,b)->tr.benefit.get(b) - tr.benefit.get(a));
        for (String s : strings){
            maxHeap.add(s);
        }

        List<String> result = new ArrayList<>();
        int maxB = 0;
        Set<String> markedOff = new HashSet<>();//set containing prefix neighbor in dict of the string that is added
        while (!maxHeap.isEmpty()){
            String s = maxHeap.remove();
            //add, then cross out its smaller prefix neighbor
            if (!markedOff.contains(s)){
                maxB += tr.benefit.get(s);

                String neighbor = tr.getSmallerPrefixNeighbor(s);
                if (neighbor != null) {
                    markedOff.add(neighbor);
                }
            }
        }
        return maxB;
    }
}


