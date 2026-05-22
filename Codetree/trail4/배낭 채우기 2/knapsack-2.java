import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int m, int[] w, int[] v) {
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = dp[i-1][j];

                if(w[i-1] <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-w[i-1]] + v[i-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] W = new int[N];
        int[] V = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, M, W, V));
    }
}
