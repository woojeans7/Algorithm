import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int n, m;
    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;

        // 각 칸이 속한 석유 덩어리 번호
        int[][] compId = new int[n][m];
        for(int[] row : compId) Arrays.fill(row, -1);

        List<Integer> compSize = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && compId[i][j] == -1){
                    int idx = compSize.size();
                    compSize.add(bfs(idx, i, j, land, compId));
                }
            }
        }

        for(int j = 0; j < m; j++){
            Set<Integer> set = new HashSet<>();
            int oil = 0;
            for(int i = 0; i < n; i++){
                int idx = compId[i][j];
                if(idx != -1 && set.add(idx)){
                    oil += compSize.get(idx);
                }
            }
            answer = Math.max(answer, oil);
        }

        return answer;
    }
    private int bfs(int idx, int row, int col, int[][] land, int[][] compId){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        compId[row][col] = idx;
        int count = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            count++;
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(isValid(nr, nc) && compId[nr][nc] == -1){
                    if(land[nr][nc] == 1){
                        compId[nr][nc] = idx;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
