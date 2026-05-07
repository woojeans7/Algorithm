import java.io.*;
import java.util.*;

public class Main {
    int n;
    int m;
    public int[] solution(int[][] town) {
        n = town.length;
        m = town[0].length;

        int maxHeight = 0;
        for (int[] row : town)
            for (int h : row)
                maxHeight = Math.max(maxHeight, h);

        int max = 0;
        int bestK = 1;

        for(int k = 1; k <= maxHeight; k++){
            boolean[][] visited = new boolean[n][m];
            int count = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(town[i][j] <= k || visited[i][j]) continue;
                    dfs(town, i, j, visited, k);
                    count++;
                }
            }
            if(count > max){
                max = count;
                bestK = k;
            }
        }

        return new  int[]{bestK, max};
    }
    private void dfs(int[][] town, int r, int c, boolean[][] visited, int k){
        visited[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(isValid(nr, nc) && !visited[nr][nc]){
                if(town[nr][nc] > k){
                    dfs(town, nr, nc, visited, k);
                }
            }
        }
    }
    private boolean isValid(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        int[] answer = main.solution(grid);
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
