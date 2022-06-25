package Micro;

public class MaximalRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] cnt = new int[n];
        boolean[][] isConnected = new boolean[n][n];
        int rank = 0;
        for(int[] road: roads){
            cnt[road[0]]++;
            cnt[road[1]]++;
            isConnected[road[0]][road[1]] = true;
            isConnected[road[1]][road[0]] = true;
        }
        for(int i=0;i<n;i++){
            for(int j =i+1;j<n;j++){
                rank = Math.max(rank,cnt[i] + cnt[j] - (isConnected[i][j]?1:0));
            }
        }
        return rank;
    }
    public static void main(String...args){
        MaximalRank maximalRank = new MaximalRank();
        int[][] ip = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        maximalRank.maximalNetworkRank(5,ip);
    }
}
