class Solution {
    public int swimInWater(int[][] grid) {
        // 4방향 이동 가능
        // 최소 t를 구하는 문제

        // (0,0)부터 (n-1, n-1)까지 이동할 수 있는 경로 중에서
        // 가장 높은 수위가 최소인 것을 구하는 문제

        int n = grid.length;

        int low = 0;
        int high = n * n;

        int answer = 0;

        while(low <= high){
            int mid = (low + high) / 2;

            if(canSwim(grid, n, mid)){
                answer = mid;
                high = mid - 1; // 더 짧은게 있는지 탐색
            }
            else{
                low = mid + 1;
            }
        }

        return answer;
    }
    private boolean canSwim(int[][] grid, int n, int t){
        // t시간 내에 이동할 수 있는지를 체크

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int row = cur[0];
            int col = cur[1];

            if(row == n-1 && col == n-1) return true;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;

                if(grid[row][col] > t || grid[nr][nc] > t) continue;

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        return false;
    }
}