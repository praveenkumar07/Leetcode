package sliding;

import java.util.*;

public class LongestSubstringKDistinct {
   private  static int findLength(String str, int k) {
        System.out.println(str);
        int result =Integer.MIN_VALUE;
        int start =0;
        int window =0;
        Map<Character,Integer> map = new HashMap<>();
        while(start<str.length()){
            map.put(str.charAt(start),map.getOrDefault(str.charAt(start),0)+1);
            while(map.size()>k){
                map.put(str.charAt(window),map.get(str.charAt(window))-1);
                if(map.get(str.charAt(window))==0){
                    map.remove(str.charAt(window));
                }
                window++;
            }
            result = Math.max(result,start -window +1);
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }

}

