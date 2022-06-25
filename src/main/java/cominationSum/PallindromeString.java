package cominationSum;

import java.util.ArrayList;
import java.util.List;

public class PallindromeString {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTracking(result,s,0,new ArrayList<>());
        return result;
    }
    private void backTracking(List<List<String>> result,String s,int start,List<String> temp){
        if(start==s.length())
            result.add(temp);
        else{
            for(int i=start;i<s.length();i++){
                String ss =s.substring(start,i+1) ;
                if(isPalindrome(s,start,i)){
                    temp.add(s.substring(start,i+1));
                    backTracking(result,s,i+1,new ArrayList<>(temp));
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    private boolean isPalindrome(String s,int low,int high) {
        while(low<high){
            if(s.charAt(low++)!= s.charAt(high--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        PallindromeString combination = new PallindromeString();
        List<List<String>> result;
        //System.out.println("Here is the list of subsets: " + result);

        result = combination.partition("aab");
        System.out.println("Here is the list of subsets: " + result);
    }
}
