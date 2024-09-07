class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }


        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);

        TreeNode p = root.left.left; 
        TreeNode q = root.left.right; 

        TreeNode lca = tree.lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("The LCA of " + p.val + " and " + q.val + " is " + lca.val);
        } else {
            System.out.println("LCA does not exist for " + p.val + " and " + q.val);
        }
    }
}
