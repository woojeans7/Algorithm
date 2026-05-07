import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n) {
        
        if(n == 2 || n == 3) return 1;
        
        int[] dp = new int[n + 1];
        
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i - 3] + dp[i - 2]) % 10007;
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
