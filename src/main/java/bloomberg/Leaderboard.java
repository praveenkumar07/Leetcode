package bloomberg;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leaderboard {
    Map<Integer,Integer> leaderMap;
    public Leaderboard() {
        leaderMap = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        leaderMap.put(playerId,leaderMap.getOrDefault(playerId,0)+score);
    }

    public int top(int K) {
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->leaderMap.get(b)-leaderMap.get(a));
        pq.addAll(leaderMap.keySet());
        int result =0;
        while(K-->0){
            result+=leaderMap.get(pq.poll());
        }
        return result;
    }

    public void reset(int playerId) {
        leaderMap.remove(playerId);
    }

    public static void main(String...args){
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1,13);
        leaderboard.addScore(2,93);
        leaderboard.addScore(3,84);
        leaderboard.addScore(4,6);
        leaderboard.addScore(5,89);
        leaderboard.addScore(6,31);
        leaderboard.addScore(7,7);
        leaderboard.addScore(8,1);
        leaderboard.addScore(9,98);
        leaderboard.addScore(10,42);
        System.out.println(leaderboard.top(5));
        leaderboard.reset(1);
        leaderboard.reset(2);
        leaderboard.addScore(3,76);
        leaderboard.addScore(4,68);
        System.out.println(leaderboard.top(1));
        leaderboard.reset(3);
        leaderboard.reset(4);
        leaderboard.addScore(2,70);
        leaderboard.reset(42);
    }
}
