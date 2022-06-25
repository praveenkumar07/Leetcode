package Micro;

public class LongestPalidromeString {
    public String longestPalindrome(String s) {
        String result = s.substring(0,1);
        for(int i=0;i<s.length();i++){
            String tmp = isPalindrom(s,i,i);
            if(tmp.length()>result.length()){
                result = tmp;
            }
            tmp = isPalindrom(s,i,i+1);
            if(tmp.length()>result.length()){
                result = tmp;
            }
        }
        return result;
    }
    private String isPalindrom(String s,int start,int end){
        while(start>=0 && end<=s.length()-1 && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
    public static void main(String[] args) {
        LongestPalidromeString longestPalidromeString = new LongestPalidromeString();
        longestPalidromeString.longestPalindrome("babad");
    }
}
