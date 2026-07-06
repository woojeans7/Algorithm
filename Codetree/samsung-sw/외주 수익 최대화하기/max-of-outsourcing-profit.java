import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] terms, int[] prices) {

        // 휴가 n일 dp[n]
        // dp[i] = i일까지 얻을 수 있는 수익의 최대값
        int[] dp = new int[n + 2];

        for(int i = n; i >= 1; i--) {
            int end = i + terms[i - 1];

            dp[i] = dp[i + 1];

            if(end <= n + 1){
                dp[i] = Math.max(dp[i], prices[i - 1] + dp[end]);
            }
        }

        return dp[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N];
        int[] P = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, T, P));
    }
}
