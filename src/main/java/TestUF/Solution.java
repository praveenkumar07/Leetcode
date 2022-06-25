package TestUF;

import java.util.Arrays;

class Solution {

    public boolean validTree(int n, int[][] edges) {

        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];

            if (!unionFind.union(A, B)) {
                return false;
            }
        }
        return edges.length == n - 1;
    }

    class UnionFind {

        private int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int node = 0; node < n; node++) {
                parent[node] = node;
            }
        }
        public int find(int A) {
            while (parent[A] != A) {
                A = parent[A];
            }
            return A;
        }

        public boolean union(int A, int B) {
            int rootA = find(A);
            int rootB = find(B);
            if (rootA == rootB) {
                return false;
            }
            parent[rootB] = rootA;
            return true;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = new int[5][2];
        edges[0] = new int[]{0,1};
        edges[1] = new int[]{1,2};
        edges[2] = new int[]{2,3};
        edges[3] = new int[]{1,3};
        edges[4] = new int[]{1,4};
        System.out.println(solution.validTree(5,edges));

    }
}
