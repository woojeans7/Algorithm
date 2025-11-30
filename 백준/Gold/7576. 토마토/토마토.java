import java.util.*;
import java.io.*;

/*
    BAEKJOON 7576번 토마토
    https://www.acmicpc.net/problem/7576
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //System.out.println(Arrays.deepToString(grid));

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dr = new int[]{0, 0, -1, 1};
        int[] dc = new int[]{-1, 1, 0, 0};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    if(grid[nr][nc] == 0){
                        grid[nr][nc] = grid[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, grid[i][j]);
            }
        }
        System.out.println(answer - 1);
    }
}
