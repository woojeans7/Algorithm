class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        List<Integer> sumList = new ArrayList<>();

        while(!queue.isEmpty()){
            int len = queue.size();

            int sum = 0;
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();

                sum += node.val;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                
            }
            sumList.add(sum);
        }

        int max = Integer.MIN_VALUE;
        int minLevel = 0;
        for(int i = 0; i < sumList.size(); i++){
            if(sumList.get(i) > max){
                max = sumList.get(i);
                minLevel = i + 1;
            }
        }

        return minLevel;
    }
}