import java.util.*;

class Solution {
    public int solution(int[][] board) {
        
        // 직선 100원, 코너 500원
        // 같은 방향일 경우에만 처리, 다른 방향일 경우에 코너 처리
        
        // 0 하, 1 상, 2 우, 3 좌
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        int n = board.length;
        
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[3]));
        int[][][] distance = new int[n][n][4];
        
        int INF = Integer.MAX_VALUE;
        for(int[][] dist : distance){
            for(int[] rows : dist) Arrays.fill(rows, INF);
        }
        
        for(int d = 0; d < 4; d++){
            pq.offer(new int[]{0, 0, d, 0});
            distance[0][0][d] = 0;
        }
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            int dir = cur[2];
            int cost = cur[3];
            
            if(distance[row][col][dir] < cost) continue;
            
            for(int d = 0; d < 4; d++){
                int nr = row + dr[d];
                int nc = col + dc[d];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] == 1) continue;
                
                int nextCost = cost + 100 + (dir == d ? 0 : 500);
                
                if(nextCost < distance[nr][nc][d]){
                    pq.offer(new int[]{nr, nc, d, nextCost});
                    distance[nr][nc][d] = nextCost;
                }
            }
        }
        int answer = INF;
        
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer, distance[n-1][n-1][i]);
        }
        
        
        return answer;
    }
}