class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;

        int[][] efforts = new int[n][m];
        int INF = 1_000_000;
        for(int[] e : efforts) Arrays.fill(e, INF);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        pq.offer(new int[]{0, 0, 0});
        efforts[0][0] = 0;

        // 상, 하, 좌, 우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int row = cur[0];
            int col = cur[1];
            int w = cur[2];

            // lazy delete
            if(efforts[row][col] < w) continue;

            if(row == n-1 && col == m-1) return w;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int ne = Math.max(w, Math.abs(heights[nr][nc] - heights[row][col]));

                    if(ne < efforts[nr][nc]){
                        pq.offer(new int[]{nr, nc, ne});
                        efforts[nr][nc] = ne;
                    }
                }
            }
        }

        return 0;
    }
}