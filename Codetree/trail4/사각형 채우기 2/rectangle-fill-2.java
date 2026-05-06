import java.io.*;
import java.util.*;

public class Main {
    public long solution(int n) {

        if(n == 1) return 1;

        long[] dp =  new long[n];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        return dp[n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(N));
    }
}
