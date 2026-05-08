import java.io.*;
import java.util.*;

public class Main {
    int answer;
    int n, k, u, d;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int[][] grid, int K, int U, int D) {
        n = grid.length;
        k = K;
        u = U;
        d = D;

        boolean[] chosen = new boolean[n * n];
        backtrack(0, 0, chosen, grid);

        return answer;
    }
    private void backtrack(int idx, int count, boolean[] chosen, int[][] grid){
        if(count == k){
            answer = Math.max(answer, bfs(chosen, grid));
            return;
        }

        if((n * n) - idx < k - count) return;

        for(int i = idx; i < n * n; i++){
            chosen[i] = true;
            backtrack(i + 1, count + 1, chosen, grid);
            chosen[i] = false;
        }

    }
    private int bfs(boolean[] chosen, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];


        for(int i = 0; i < n * n; i++){
            if(chosen[i]){
                int r =  i / n, c = i % n;
                queue.add(new int[]{r, c});
                visited[r][c] = true;
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int[] cur =  queue.poll();
            int row = cur[0];
            int col = cur[1];

            count++;
            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(!visited[nr][nc] && diff(row, col, nr, nc, grid)){
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
    private boolean diff(int r, int c, int nr, int nc, int[][] grid){
        int diff = Math.abs(grid[r][c] - grid[nr][nc]);
        return (diff >= u && diff <= d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(grid, K, U, D));
    }
}
