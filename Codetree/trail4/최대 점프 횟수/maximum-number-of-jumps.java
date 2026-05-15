import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums) {
        int n = nums.length;
        int INF = Integer.MIN_VALUE;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == INF) continue;
                if (j + nums[j] >= i)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i]);

        return ans;
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
