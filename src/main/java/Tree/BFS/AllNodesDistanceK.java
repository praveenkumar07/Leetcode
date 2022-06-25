package Tree.BFS;

import Tree.TreeNode;

import java.util.*;

public class AllNodesDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        mapParent(root,parent);
        q.offer(target);
        visited.add(target);
        int currentDist =0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                if(currentDist==k){
                    for(TreeNode n:q){
                        result.add(n.val);
                    }
                    return result;
                }
                TreeNode curr = q.poll();
                if(curr.left!=null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode par = parent.get(curr);
                if(par!=null && !visited.contains(par)){
                    visited.add(par);
                    q.offer(par);
                }
            }
            currentDist++;
        }
        return result;
    }
    private void mapParent(TreeNode root,Map<TreeNode,TreeNode> parent){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode parentNode = q.poll();
                if(parentNode.left!=null){
                    parent.put(parentNode.left,parentNode);
                    q.offer(parentNode.left);
                }
                if(parentNode.right!=null){
                    parent.put(parentNode.right,parentNode);
                    q.offer(parentNode.right);
                }
                if(!parent.containsKey(parentNode))
                    parent.put(parentNode,null);
            }
        }
    }
    public static void main(String...args){
        AllNodesDistanceK allNodesDistanceK = new AllNodesDistanceK();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right= new TreeNode(2);
        root.left.right.left= new TreeNode(7);
        root.left.right.right= new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        allNodesDistanceK.distanceK(root,root.left,2);
    }
}
