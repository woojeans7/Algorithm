import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] grid) {
        int n = grid.length;
        int INF = Integer.MAX_VALUE / 2;
        int answer = INF;

        for (int lo = 1; lo <= 100; lo++) {
            int[][] dp = new int[n][n];

            // 시작점
            dp[0][0] = grid[0][0] >= lo ? grid[0][0] : INF;

            // 첫 행
            for (int j = 1; j < n; j++) {
                if (dp[0][j-1] == INF || grid[0][j] < lo)
                    dp[0][j] = INF;
                else
                    dp[0][j] = Math.max(dp[0][j-1], grid[0][j]);
            }

            // 첫 열
            for (int i = 1; i < n; i++) {
                if (dp[i-1][0] == INF || grid[i][0] < lo)
                    dp[i][0] = INF;
                else
                    dp[i][0] = Math.max(dp[i-1][0], grid[i][0]);
            }

            // 나머지
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (grid[i][j] < lo) {
                        dp[i][j] = INF;
                        continue;
                    }
                    int fromTop  = dp[i-1][j] == INF ? INF : Math.max(dp[i-1][j], grid[i][j]);
                    int fromLeft = dp[i][j-1] == INF ? INF : Math.max(dp[i][j-1], grid[i][j]);
                    dp[i][j] = Math.min(fromTop, fromLeft);
                }
            }

            if (dp[n-1][n-1] != INF) {
                answer = Math.min(answer, dp[n-1][n-1] - lo);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
