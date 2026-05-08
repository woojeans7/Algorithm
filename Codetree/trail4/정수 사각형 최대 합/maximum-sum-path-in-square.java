import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[][] grid) {
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for(int i =1; i<n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[n-1][n-1];
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
        System.out.println(main.solution(N, grid));
    }
}
