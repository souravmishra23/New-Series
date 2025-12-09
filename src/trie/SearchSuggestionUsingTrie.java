package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionUsingTrie {
    public static void main(String[] args) {
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode node = new TrieNode();

        for (String pro: products) {
            insert(pro, node);
        }

        for (char ch: searchWord.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
                result.add(node.getTopThree());
            } else {
                break;
            }
        }

        return result;
    }

    public void insert(String pro, TrieNode root) {
        TrieNode node = root;
        for (char ch: pro.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch);
            }
            node = node.get(ch);
            node.addToPQ(pro);
        }
    }
}



class TrieNode {
    TrieNode [] childs = new TrieNode[26];
    PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());

    TrieNode get(char ch) {
        return childs[ch - 'a'];
    }

    boolean containsKey(char ch) {
        return childs[ch = 'a'] != null;
    }

    void put(char ch) {
        childs[ch - 'a'] = new TrieNode();
    }

    void addToPQ(String word) {
        pq.add(word);
        if (pq.size() > 3) {
            pq.poll();
        }
    }

    List<String> getTopThree() {
        List<String> topThree = new ArrayList<>();
        while (!pq.isEmpty()) {
            topThree.add(pq.poll());
        }
        Collections.reverse(topThree);
        return topThree;
    }   
}
