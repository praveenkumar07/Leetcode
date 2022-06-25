package sliding;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int maxRepeat = 0;
        int window = 0;

        int max = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i),0) + 1);
            maxRepeat = Math.max(maxRepeat, hm.get(str.charAt(i)));
            if (i - window + 1 - maxRepeat > k) {
                hm.put(str.charAt(window), hm.get(str.charAt(window)) - 1);
                window++;
            }

            max = Math.max(max, i - window + 1);

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
