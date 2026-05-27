import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        // dp[d + total] = "A합 - B합 = d일 때 A합의 최대값", -1이면 불가능
        int[] dp = new int[2 * total + 1];
        Arrays.fill(dp, -1);
        dp[total] = 0;

        for (int num : nums) {
            int[] next = dp.clone();
            for (int d = 0; d <= 2 * total; d++) {
                if (dp[d] == -1) continue;
                // A에 넣기: 차이 +num, A합 +num
                if (d + num <= 2 * total)
                    next[d + num] = Math.max(next[d + num], dp[d] + num);
                // B에 넣기: 차이 -num, A합 그대로
                if (d - num >= 0)
                    next[d - num] = Math.max(next[d - num], dp[d]);
                // C에 넣기: next[d]는 이미 dp[d]로 초기화됨
            }
            dp = next;
        }

        return Math.max(0, dp[total]); 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Main main = new Main();
        System.out.println(main.solution(A));
    }
}