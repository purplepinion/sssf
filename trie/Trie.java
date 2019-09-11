package com.chrisz.algorithm.example.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    char c;
    Map<Character,TrieNode> childMap;
    boolean hasWord;

    TrieNode(char c){
        this.c = c;
        childMap = new HashMap<Character,TrieNode>();
    }
}
public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }


    public void insert(String word) {
        TrieNode cur = root;

        char[] words = word.toCharArray();
        Map<Character,TrieNode> curChild = root.childMap;

        for (int i = 0; i < words.length; i++) {
            char wc = words[i];

            if(curChild.containsKey(wc)){
                cur = curChild.get(wc);
            }else {
                TrieNode newNode = new TrieNode(wc);
                curChild.put(wc,newNode);
                cur = newNode;
            }

            curChild = cur.childMap;

            if(i == words.length-1){
                cur.hasWord = true;
            }
        }
    }


    public boolean search(String word) {
        if(searchWordNodePos(word)!=null&&searchWordNodePos(word).hasWord){
            return true;
        }

        return false;
    }


    public boolean startsWith(String prefix) {

        return searchWordNodePos(prefix)!=null;
    }

    public TrieNode searchWordNodePos(String s){
        Map<Character,TrieNode> curChild = root.childMap;

        TrieNode cur = null;

        char[] words = s.toCharArray();

        for (int i = 0; i < words.length; i++) {

            char wc = words[i];
            if(curChild.containsKey(wc)){
                cur = curChild.get(wc);
                curChild = cur.childMap;
            }else {
                return null;
            }

        }

        return cur;
    }
}
