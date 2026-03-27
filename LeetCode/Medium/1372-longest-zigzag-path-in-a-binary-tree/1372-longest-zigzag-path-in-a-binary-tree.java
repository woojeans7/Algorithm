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
    private int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        maxZigZag(root, true, 0); // 왼쪽 시작
        maxZigZag(root, false, 0); // 오른쪽 시작
        return maxLen;
    }
    private void maxZigZag(TreeNode node, boolean direction, int len){
        if(node == null) return;
        maxLen = Math.max(maxLen, len);

        if(direction){
            maxZigZag(node.left, false, len + 1);
            maxZigZag(node.right, true, 1); // 초기화
        }
        else{
            maxZigZag(node.right, true, len + 1);
            maxZigZag(node.left, false, 1); // 초기화
        }
    }
}