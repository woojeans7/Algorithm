import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[][] dp = new int[41][2];
        for(int i = 0; i <= 40; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= 40; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        //System.out.println(Arrays.toString(arr));

         StringBuilder sb = new StringBuilder();
         for(int i = 0; i < T; i++){
             int n = Integer.parseInt(br.readLine());
             sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
         }
         System.out.println(sb);
    }

}
