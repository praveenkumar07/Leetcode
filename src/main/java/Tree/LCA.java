package Tree;

public class LCA {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            return l != null && r != null?root : l == null?r: l;
        }

        public static void main(String...args){
            LCA lca = new LCA();
            TreeNode p = new TreeNode(5);
            p.left = new TreeNode(6);
            p.right = new TreeNode(2);
            p.right.left = new TreeNode(7);
            TreeNode q = new TreeNode(4);
            p.right.right = q;

            TreeNode root = new TreeNode(3);
            root.left =p;
            root.right = new TreeNode(1);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);

            lca.lowestCommonAncestor(root , p ,q);
        }
    }
