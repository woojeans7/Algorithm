import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 0 || grid[n-1][m-1] == 0) return 0;

        boolean[][] visited = new boolean[n][m];
        boolean answer = dfs(grid,0, 0, n, m, visited);

        return answer ? 1 : 0;
    }
    private boolean dfs(int[][] grid, int r, int c, int n, int m, boolean[][] visited) {

        if(r == n-1 && c == m-1) return true;

        visited[r][c] = true;

        int[] dr = {1,0};
        int[] dc = {0,1};

        for(int i = 0; i < 2; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 &&  nc < m && !visited[nr][nc] && grid[nr][nc] == 1){
                if(dfs(grid, nr, nc, n, m, visited)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
