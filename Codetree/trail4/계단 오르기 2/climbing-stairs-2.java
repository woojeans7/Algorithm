import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][4];
        for(int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);

        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= 3; j++) {
                // 2칸으로 올라온 경우
                if(i >= 2 && dp[i-2][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-2][j] + coins[i-1]);
                }

                // 1칸으로 올라온 경우
                if(j >= 1 && dp[i-1][j-1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + coins[i-1]);
                }
            }
        }

        // n층에서 1칸 이동 횟수 0~3 중 최대
        int answer = 0;
        for(int j = 0; j <= 3; j++) {
            if (dp[n][j] != Integer.MIN_VALUE)
                answer = Math.max(answer, dp[n][j]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
