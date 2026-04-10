class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();

        int winner = 0;

        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            for(int i = 1; i < k; i++){
                int w = queue.poll();
                queue.offer(w);
            }
            winner = queue.poll();
            if(queue.size() == 1){
                winner = queue.poll();
            }
        }
        return winner;
    }
}