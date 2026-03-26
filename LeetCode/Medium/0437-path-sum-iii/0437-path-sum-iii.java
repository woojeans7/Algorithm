class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);
        int count = dfs(root, targetSum, 0L, prefixMap);

        return count;

    }
    private int dfs(TreeNode node, int targetSum, long curSum, Map<Long, Integer> map){
        if(node == null) return 0;

        curSum += node.val;
        // curSum - targetSum이 이전에 등장한 값인지 체크
        int count = map.getOrDefault(curSum - targetSum, 0);
        // 현재 누적합 저장
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        count += dfs(node.left, targetSum, curSum, map);
        count += dfs(node.right, targetSum, curSum, map);

        map.put(curSum, map.get(curSum) - 1); // 백트래킹

        return count;
    }
}