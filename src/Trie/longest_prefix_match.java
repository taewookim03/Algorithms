package Trie;

import java.util.HashMap;
import java.util.Map;

/**
 http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 Given a dictionary of words and an input string, find the longest prefix of the string which is also a word in dictionary.
 */
class TrieNode{
    char value;
    Map<Character, TrieNode> children;
    boolean isEnd;

    TrieNode(char c){
        value = c;
        children = new HashMap<>();
        isEnd = false;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode('\0');
    }

    void insert(String word){
        //iterate over each char and insert to trie
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            Map<Character, TrieNode> children = node.children;
            char c = word.charAt(i);

            if (children.containsKey(c)){
                node = children.get(c);
            }
            else{
                TrieNode temp = new TrieNode(c);
                children.put(c, temp);
                node = temp;
            }
        }
        //mark last char as end of word
        node.isEnd = true;
    }
    String getMatchingPrefix(String input){
        String result = "NO MATCHES";
        StringBuilder sb = new StringBuilder();
        TrieNode crawl = root;

        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            Map<Character, TrieNode> children = crawl.children;
            if (children.containsKey(ch)){
                crawl = children.get(ch);
                sb.append(ch);
                if (crawl.isEnd){
                    result = sb.toString();
                }
            }
            else{
                break;
            }
        }
        return result;
    }
}

// Testing class
class Test {
    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
        dict.insert("basement");

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));
        /*
        expected input
        caterer:   cater
        basement:   basement
        are:   are
        arex:   are
        basemexz:   base
        xyz:
         */
    }
}