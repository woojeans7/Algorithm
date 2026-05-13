import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[][] grid) {
        int[][] dp =  new int[n][n];
        dp[0][n-1] = grid[0][n-1];
        for(int i = n-2; i >= 0; i--) {
            dp[0][i] = dp[0][i+1] + grid[0][i];
        }
        for(int i = 1; i < n; i++) {
            dp[i][n-1] = dp[i-1][n-1] + grid[i][n-1];
        }

        for(int i = 1; i < n; i++){
            for(int j = n-2; j >= 0; j--){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) +  grid[i][j];
            }
        }

        return dp[n-1][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(N, A));
    }
}
