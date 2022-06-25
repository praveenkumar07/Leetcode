package Tree.DFS;

import Tree.TreeNode;

public class DiameterOfTree {
    static int diameter =0;
    public static int findDiameter(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return diameter+1;
    }
    private static int dfs(TreeNode r){
        if(r == null) return 0;
        int left = dfs(r.left);
        int right = dfs(r.right);
        diameter = Math.max(diameter,left+right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + DiameterOfTree.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + DiameterOfTree.findDiameter(root));
    }
}
