package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word;
    boolean isWord;

    TrieNode() {

    }

    public static void main(String... args) {
        ReplaceWords replaceWords = new ReplaceWords();
        ArrayList<String> dic = new ArrayList<>();
        dic.add("cat");
        dic.add("bat");
        dic.add("rat");
        System.out.println(replaceWords.replaceWords(dic, "the cattle was rattled by the battery"));
    }
}
