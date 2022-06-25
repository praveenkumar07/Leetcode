package Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode trie = new TrieNode();
        insertToTrie(words,trie);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                searchTrie(board,trie,result,i,j);
            }
        }
        return result;
    }
    private void searchTrie(char[][] board ,TrieNode trie,List<String> result ,int i, int j){
        if( i >= board.length || j>=board[0].length|| i<0 || j<0|| board[i][j]=='#' ||trie==null)
            return;
        TrieNode curr = trie;
        if(curr.isWord) {
            result.add(curr.word);
            curr.word = null;
            curr.isWord = false;
        }
        char c = board[i][j];
        board[i][j]='#';
        searchTrie(board,curr.children.get(c),result,i+1,j);
        searchTrie(board,curr.children.get(c),result,i-1,j);
        searchTrie(board,curr.children.get(c),result,i,j+1);
        searchTrie(board,curr.children.get(c),result,i,j-1);
        board[i][j] = c;
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
            System.out.println(cur.word);
        }
    }
    public static void main(String...args){
        WordSearch wordSearch = new WordSearch();
    }
}
