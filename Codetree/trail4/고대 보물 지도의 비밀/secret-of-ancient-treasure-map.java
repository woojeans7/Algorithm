import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int k, int[] map) {
        int[][] dp = new int[n][k+1];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE / 2);

        if (map[0] >= 0) dp[0][0] = map[0];
        else dp[0][1] = map[0];

        for (int i = 1; i < n; i++) {
            if (map[i] >= 0) {
                for(int j = 0; j <= k; j++){
                    dp[i][j] = map[i];
                    if (dp[i-1][j] == Integer.MIN_VALUE / 2) continue;
                    dp[i][j] = Math.max(dp[i-1][j] + map[i], dp[i][j]);
                }
            }
            else{
                for(int j = 1; j <= k; j++){
                    dp[i][j] = map[i];
                    if (dp[i-1][j-1] == Integer.MIN_VALUE / 2) continue;
                    dp[i][j] = Math.max(dp[i-1][j-1] + map[i], dp[i][j]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= k; j++){
                if (dp[i][j] != Integer.MIN_VALUE / 2)
                    answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, K, A));
    }
}
