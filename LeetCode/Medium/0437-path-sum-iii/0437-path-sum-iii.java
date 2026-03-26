class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); 
        return dfs(root, 0, targetSum, map);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> map) {
        if (node == null) return 0;
        currSum += node.val;
        int count = map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, targetSum, map);
        count += dfs(node.right, currSum, targetSum, map);

        map.put(currSum, map.get(currSum) - 1);
        return count;
    }
}