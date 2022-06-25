package fastslow;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean find(int num) {
        int sum =0;
        int digit =0;
        Set<Integer> v = new HashSet<>();
        while(num>0){
            digit = num%10;
            sum+= digit *digit;
            num = num/10;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
       // System.out.println(HappyNumber.find(12));
    }
}
