class Solution {
    public int coinChange(int[] coins, int amount) {
        // BFS 최단거리 구하기
        // 시작점 예약 (amount == 0)
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount+1]; // 11번 노드까지 체크해야 함.
        
        queue.offer(new int[]{0,0}); // 초기값, 사용한 동전 수 
        visited[0] = true;

        while(!queue.isEmpty()){
            // 현재 노드 방문
            int[] cur = queue.poll();
            int cur_amount = cur[0], count = cur[1];

            // if 현재 노드 == 11; return count;
            if(cur_amount == amount) return count;

            // 다음 노드 예약
            for(int coin : coins){
                int next_amount = cur_amount + coin; // 다음 노드 구하기
                if(next_amount >=0 && next_amount <= amount && !visited[next_amount]){
                    queue.offer(new int[]{next_amount, count + 1});
                    visited[next_amount] = true;
                }
            }
        
        }

        return -1;
    }
}