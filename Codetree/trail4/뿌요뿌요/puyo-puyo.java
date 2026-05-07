import java.io.*;
import java.util.*;

public class Main {
    int n;
    public int[] solution(int[][] grid) {
        n = grid.length;

        boolean[][] visited = new boolean[n][n];

        int maxArea = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                int cur = grid[i][j];
                int area = dfs(i, j, grid, visited, cur); // 영역의 크기 계산
                if(area >= 4) count++; // 영역이 4 이상이면 터진 영역의 수 계산
                maxArea = Math.max(maxArea, area);
            }
        }

        return new int[]{count, maxArea};
    }
    private int dfs(int r, int c, int[][] grid, boolean[][] visited, int cur) {
        visited[r][c] = true;
        int count = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(isValid(nr, nc) && !visited[nr][nc]){
                if(grid[nr][nc] == cur){
                    count += dfs(nr, nc, grid, visited, cur);
                }
            }
        }

        return count;
    }
    private boolean isValid(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        int[] answer = main.solution(grid);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
