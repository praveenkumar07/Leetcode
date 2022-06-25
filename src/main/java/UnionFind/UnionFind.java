package UnionFind;

public class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;

        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(0, 2);
        uf.union(0, 3);
//        uf.union(1, 3);
        uf.union(1, 4);
//        uf.union(6, 7);
//        uf.union(3, 8);
//        uf.union(8, 9);
        System.out.println(uf.connected(0, 2));
        System.out.println(uf.connected(0, 3));
//        System.out.println(uf.connected(4, 9));
//        uf.union(9, 4);
//        System.out.println(uf.connected(4, 9));
    }
}
