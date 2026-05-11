import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n) {
        int[] dp = new int[n+1];
        int[] nums = {1, 2, 5};
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for(int num : nums) {
                if(i >= num) {
                    dp[i] = (dp[i] + dp[i - num]) % 10007;
                }
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
