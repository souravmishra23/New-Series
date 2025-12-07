package trie;

public class ImplementTrie {
    public static void main(String[] args) {
    }
}

class Trie {



    class Node {
        Node [] childs;
        boolean isEnd;

        Node() {
            childs = new Node[26];
        }

        boolean containsKey(char ch) {
            return childs[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            childs[ch - 'a'] = node;
        }

        Node get(char ch) {
            return childs[ch - 'a'];
        }
    }


    private final Node root;

    public Trie() {
        root = new Node();
        root.childs = new Node[26];
    }

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.containsKey(ch)) {
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!curr.containsKey(ch)) {
                return false;
            }
            curr = curr.get(ch);
        }

        return curr.isEnd;
    }

    public boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.containsKey(ch)) {
                return false;
            }
            curr = curr.get(ch);
        }
        return true;
    }


}
