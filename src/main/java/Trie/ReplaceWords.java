package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        // insert into Trie
        insertToTrie(roots, trie);
        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");
            TrieNode cur = trie;
            ans.append(searchWord(word, cur));
        }
        return ans.toString();
    }

    /**
     * @param word word to be replaced
     * @param cur  current trie element
     * @return found word or given word
     */
    private String searchWord(String word, TrieNode cur) {
        for (char letter : word.toCharArray()) {
            if (cur.children.get(letter) == null || cur.isWord)
                break;
            cur = cur.children.get(letter);
        }
        return cur.isWord ? cur.word : word;
    }

    /**
     * @param roots given dictionary of words to be added in trie
     * @param trie  root trie element
     */
    private void insertToTrie(List<String> roots, TrieNode trie) {
        for (String root : roots) {
            TrieNode cur = trie;
            for (char letter : root.toCharArray()) {
                if (cur.children.get(letter) == null) {
                    cur.children.put(letter, new TrieNode());
                }
                cur = cur.children.get(letter);
            }
            cur.word = root;
            cur.isWord = true;
        }
    }
}

