import java.io.*;
import java.util.*;

public class Main {
    public long solution(int n) {

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2]) % 1000000007;
            for(int j = i-3; j >= 0; j--) {
                dp[i] = (dp[i] + dp[j] * 2) % 1000000007;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(N));
    }
}
