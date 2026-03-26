/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, -10000);
    }
    private int dfs(TreeNode root, int v){
        if(root == null) return 0;
        
        int good = root.val >= v ? 1 : 0;
        good += dfs(root.left, Math.max(root.val, v));
        good += dfs(root.right, Math.max(root.val, v));

        return good;
    }
}