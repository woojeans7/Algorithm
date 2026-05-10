import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for(int coin : coins) {
            for(int i = amount; i >= 0; i--) {
                if(i >= coin) {
                    if(dp[i - coin] == INF) continue;
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(A, M));
    }
}
