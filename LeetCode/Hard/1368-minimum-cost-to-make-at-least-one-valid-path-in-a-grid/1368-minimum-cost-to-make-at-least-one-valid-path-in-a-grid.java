class Solution {
    public int minCost(int[][] grid) {
        // 도착지에 도달하면 종료
        // 격자에 적혀있는 방향으로만 탐색
        // 1: 우, 2: 좌, 3: 하, 4: 상
        int[] dr = {0, 0, 0, 1, -1};
        int[] dc = {0, 1, -1, 0, 0};

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] distance = new int[m][n];
        int INF = Integer.MAX_VALUE;

        for(int[] dis : distance) Arrays.fill(dis, INF);
        pq.offer(new int[]{0, 0, 0});
        distance[0][0] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            int cost = cur[2];

            if(row == m-1 && col == n-1) return cost;

            if(distance[row][col] < cost) continue;

            for(int d = 1; d <= 4; d++){
                int nr = row + dr[d];
                int nc = col + dc[d];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int newCost = cost + (grid[row][col] == d ? 0 : 1);
                if(newCost < distance[nr][nc]){
                    pq.offer(new int[]{nr, nc, newCost});
                    distance[nr][nc] = newCost;
                }
            }
        }
        return -1;
    }
}