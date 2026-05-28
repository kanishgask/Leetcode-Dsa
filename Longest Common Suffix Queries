import java.util.*;

public class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1;
    }
    
    private TrieNode root = new TrieNode();
    private String[] container;
    private int globalBestIndex; // fallback
    
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        this.container = wordsContainer;
        
        // Find global best (shortest length, earliest index)
        globalBestIndex = 0;
        for (int i = 1; i < wordsContainer.length; i++) {
            if (better(i, globalBestIndex)) {
                globalBestIndex = i;
            }
        }
        root.bestIndex = globalBestIndex; // set fallback at root
        
        // Build Trie with reversed container words
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }
        
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i]);
        }
        return ans;
    }
    
    private void insert(String word, int index) {
        String rev = new StringBuilder(word).reverse().toString();
        TrieNode node = root;
        
        for (char c : rev.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            
            if (node.bestIndex == -1 || better(index, node.bestIndex)) {
                node.bestIndex = index;
            }
        }
    }
    
    private int query(String word) {
        String rev = new StringBuilder(word).reverse().toString();
        TrieNode node = root;
        int best = root.bestIndex; // fallback
        
        for (char c : rev.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) break;
            node = node.children[idx];
            if (node.bestIndex != -1) best = node.bestIndex;
        }
        return best;
    }
    
    private boolean better(int a, int b) {
        if (container[a].length() != container[b].length()) {
            return container[a].length() < container[b].length();
        }
        return a < b;
    }
}
