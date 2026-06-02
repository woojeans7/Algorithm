import java.io.*;
import java.util.*;

public class Main {
    int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    int[] dc = {0, 0, 1, 1, 1, 0, -1, -1, -1};
    int[][] memo;
    public int solution(int n, int[][] board, int[][] directions, int[] start) {
        memo = new int[n][n];
        for(int[] row : memo) Arrays.fill(row, -1);
        int r = start[0], c = start[1];
        return dfs(r, c, n, board, directions);
    }
    private int dfs(int r, int c, int n, int[][] board, int[][] directions){
        if(memo[r][c] != -1) return memo[r][c];

        memo[r][c] = 0;
        int dir = directions[r][c];

        int nr = r + dr[dir];
        int nc = c + dc[dir];
        while(nr >= 0 && nr < n && nc >= 0 && nc < n){
            if(board[nr][nc] > board[r][c]){
                memo[r][c] = Math.max(memo[r][c], dfs(nr, nc, n, board, directions) + 1);
            }
            nr += dr[dir];
            nc += dc[dir];
        }
        return memo[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] D = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] S = new int[2];
        st = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(st.nextToken()) - 1;
        S[1] = Integer.parseInt(st.nextToken()) - 1;


        Main main = new Main();
        System.out.println(main.solution(N, B, D, S));
    }
}
