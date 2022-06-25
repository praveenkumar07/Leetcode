package Tree.DFS;

import Tree.TreeNode;

public class SumOfPathNumbers {
    static int rootSum =0;
    public static int findSumOfPathNumbers(TreeNode root) {
        dfs(root,0);
        return rootSum;
    }
    private static void dfs(TreeNode root , int sum){
        if(root==null) {
            return;
        }
        sum=sum*10+root.val;
        if(root.left==null && root.right==null) rootSum+=sum;
        dfs(root.left,sum);
        dfs(root.right,sum);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
