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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        if(root == null) return answer;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();

                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            tree.add(level);
        }

        for(List<Integer> child : tree){
            answer.add(child.get(child.size() - 1));
        }

        return answer;
    }
}