package subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTracking(result,n,0,0,"");
        return  result;
    }
    private void backTracking(List<String> result ,int max, int open ,int close,String temp){
        if(open==max && close==max) {
            result.add(temp);
            return;
        }
        if(open<max) backTracking(result,max,open+1,close,temp+"(");
        if(close<open) backTracking(result,max,open,close+1,temp+")");
    }
    public static void main(String...args){
        GenerateParenthesis generateParenthesis= new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
