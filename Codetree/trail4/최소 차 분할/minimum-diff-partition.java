import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;

        boolean[] dp = new boolean[total + 1];
        dp[0] = true;

        for(int num : nums) {
            for(int i = total; i >= num; i--) {
                if(dp[i - num]) dp[i] = true;
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int s = 0; s <= total / 2; s++) {
            if(dp[s]) {
                answer = Math.min(answer, total - 2 * s);
            }
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
