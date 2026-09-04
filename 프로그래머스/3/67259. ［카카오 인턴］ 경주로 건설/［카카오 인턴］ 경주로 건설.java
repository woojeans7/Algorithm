import java.io.*;
import java.util.*;

public class Solution {
    public int solution(int[][] board) {
        int n = board.length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int INF = Integer.MAX_VALUE;

        int[][][] dist = new int[n][n][4]; // 4방향
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dist[i][j], INF);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);

        // 모든 방향에 대해서 시작
        for (int d = 0; d < 4; d++) {
            dist[0][0][d] = 0;
            pq.offer(new int[]{0, 0, d, 0});
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            int dir = cur[2];
            int cost = cur[3];

            // 더 좋은 경로로 갔으면 넘김
            if(cost > dist[row][col][dir]) continue;

            for(int nd = 0; nd < 4; nd++){
                int nr = row + dr[nd];
                int nc = col + dc[nd];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] == 1) continue;

                int newCost = cost + 100 + (nd == dir ? 0 : 500);

                if(newCost < dist[nr][nc][nd]){
                    dist[nr][nc][nd] = newCost;
                    pq.offer(new int[]{nr, nc, nd, newCost});
                }
            }
        }

        int answer = INF;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, dist[n-1][n-1][d]);
        }

        return answer;
    }
}