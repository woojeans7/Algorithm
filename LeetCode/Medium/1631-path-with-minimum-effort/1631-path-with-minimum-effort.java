class Solution {
    public int minimumEffortPath(int[][] heights) {
        // 2. 이분탐색 풀이
        int answer = 0;

        // 이분탐색
        int low = 0;
        int high = 1_000_000;

        while(low <= high){
            int mid = (low + high) / 2;

            if(canReach(heights, mid)){
                answer = mid;
                high = mid - 1; // 더 짧은게 있는지 탐색
            }
            else{
                low = mid + 1;
            }
        }

        return answer;
    }
    // canDo 함수 (BFS)
    private boolean canReach(int[][] heights, int maxDiff){
        int n = heights.length;
        int m = heights[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int row = cur[0];
            int col = cur[1];

            if(row == n-1 && col == m-1) return true;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;

                // 절대값 차이가 임계보다 작을 경우에만 도달 가능함
                if(Math.abs(heights[nr][nc] - heights[cur[0]][cur[1]]) > maxDiff) continue;
                queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
            }
        }
        return false;
    }
}