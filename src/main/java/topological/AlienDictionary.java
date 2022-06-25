package topological;

import java.util.*;

public class AlienDictionary {
    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character,Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<>());
            }
        }
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i +1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                char parent = w1.charAt(j); char child = w2.charAt(j);
                if(parent != child){
                    graph.get(parent).add(child);
                    inDegree.put(child ,inDegree.get(child)+1);
                    break;
                }
            }
        }
        Queue<Character> source = new LinkedList<>();
        for(Map.Entry<Character,Integer> chars : inDegree.entrySet()){
            if(chars.getValue()==0)
                source.offer(chars.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while(!source.isEmpty()){
            Character s = source.poll();
            sb.append(s);
            List<Character> nextSource = graph.get(s);
            for(Character sourceValue : nextSource){
                inDegree.put(sourceValue,inDegree.get(sourceValue)-1);
                if(inDegree.get(sourceValue) ==0)
                    source.add(sourceValue);
            }
        }
        return (sb.length()!=inDegree.size())?"":String.valueOf(sb);
    }
    public static void main(String[] args) {
        String result = AlienDictionary.alienOrder(new String[] { "abc", "ab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.alienOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.alienOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
