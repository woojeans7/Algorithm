import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] red, int[] blue) {
        //  i번째 시행까지 했을 때 빨간 카드를 j개 골랐을 때 최대 합
        int[][] dp = new int[2*n][n+1];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE / 2);

        dp[0][0] = blue[0];
        dp[0][1] = red[0];

        for(int i = 1; i < 2*n; i++){
            for(int j = 0; j <= n; j++){
                if (j > 0 && dp[i-1][j-1] != Integer.MIN_VALUE / 2){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + red[i]);
                }
                if (dp[i-1][j] != Integer.MIN_VALUE / 2) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + blue[i]);
                }
            }
        }

        return dp[2*n-1][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] R = new int[2*N];
        int[] B = new int[2*N];

        for(int i = 0; i < 2*N; i++){
            st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, R, B));
    }
}
