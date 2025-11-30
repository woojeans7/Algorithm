import java.util.*;
import java.io.*;

/*
    BAEKJOON 7569번 토마토
    https://www.acmicpc.net/problem/7569
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] grid = new int[h][n][m];

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    grid[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        //System.out.println(Arrays.deepToString(grid));

        int[] dr = new int[]{0, 0, -1, 1, 0, 0};
        int[] dc = new int[]{-1, 1, 0, 0, 0, 0};
        int[] dh = new int[]{0, 0, 0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (grid[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int height = cur[0];
            int row = cur[1];
            int col = cur[2];

            for (int d = 0; d < 6; d++) {
                int nh = height + dh[d];
                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && nh >= 0 && nh < h) {
                    if (grid[nh][nr][nc] == 0) {
                        grid[nh][nr][nc] = grid[height][row][col] + 1;
                        queue.offer(new int[]{nh, nr, nc});
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(grid[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, grid[i][j][k]);
                }
            }
        }
        System.out.println(answer - 1);
    }
}
