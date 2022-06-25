package Trie;

import java.util.ArrayList;
import java.util.List;

public class SuggestedProducts {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode trie = new TrieNode();
        insertToTrie(products,trie);
        String prefix = "";
        for(Character c: searchWord.toCharArray()){
            prefix+=c;
            result.add(getWordsList(trie,prefix));
        }
        return result;
    }
    private void insertToTrie(String[] roots, TrieNode trie) {
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
    private List<String> getWordsList(TrieNode trie,String s){
        List<String> result = new ArrayList<>();
        TrieNode curr = trie;
        for(Character c: s.toCharArray()){
            if(curr.children.get(c)==null) return result;
            curr= curr.children.get(c);
        }
        dfs(curr,s,result);
        return result;
    }
    private void dfs(TrieNode curr ,String s,List<String> result){
        if(result.size()==3) return;
        if(curr.isWord) result.add(curr.word);
        // DFS starts
        for(char c='a';c<='z';c++){
            if(curr.children.get(c)!=null)
                dfs(curr.children.get(c),s+c,result);
        }
    }
    public static void main(String...args){
        SuggestedProducts suggestedProducts = new SuggestedProducts();
        suggestedProducts.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},"mouse");
    }
}
