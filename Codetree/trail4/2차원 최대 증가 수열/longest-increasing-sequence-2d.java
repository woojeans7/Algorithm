import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int INF = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];

        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 1;  // (0,0)에서만 시작

        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == INF) continue;  // 도달 불가한 칸은 스킵

                for (int r = i + 1; r < n; r++) {
                    for (int c = j + 1; c < m; c++) {
                        if (grid[r][c] > grid[i][j]) {
                            dp[r][c] = Math.max(dp[r][c], dp[i][j] + 1);
                            ans = Math.max(ans, dp[r][c]);
                        }
                    }
                }
            }
        }

        return ans;
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

        // Todo: 추가 입력 받기

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
