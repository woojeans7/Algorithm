class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] time = new int[n][n];
        for(int[] tt : time) Arrays.fill(tt, n*n);

        pq.offer(new int[]{0, 0, 0});
        time[0][0] = 0;


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int row = cur[0];
            int col = cur[1];
            int t = cur[2];

            if(row == n-1 && col == n-1) return t;

            if(time[row][col] < t) continue;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int nextTime = Math.max(t, Math.max(grid[row][col], grid[nr][nc]));

                if(nextTime < time[nr][nc]){
                    pq.offer(new int[]{nr, nc, nextTime});
                    time[nr][nc] = nextTime;
                }
            }
        }
        return 0;
    }
}