package Amazon;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] A, int M) {
        int[] mod = new int[A.length];
        for( int index=0;index<M;index++){
            mod[index]=0;
        }
        for(int index=0;index<A.length;index++){
            mod[test(A[index],M)]++;

        }

        if(mod[M-1] > 1){
            System.out.println(mod[M-1]);
        }
        List<Integer> re = Arrays.stream(mod).boxed().collect(Collectors.toList());
        Collections.sort(re);
        return re.get(re.size());
    }

    public static void main(String...args){
        Solution solution = new Solution();
        solution.solution(new int[]{-3,-2,1,0,8,7,1} , 3);
    }
    private int test (int num , int n){
        if(num<0){
            do{
                num += n;
            }while(num<0);
        }
        return num%n;
    }
}

