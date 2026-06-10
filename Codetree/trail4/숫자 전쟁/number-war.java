import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] enemy, int[] self) {
        int[][] dp = new int[n+1][n+1];


        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                int battle;
                if(enemy[i] < self[j]) battle = dp[i+1][j];
                else if(enemy[i] > self[j]) battle = dp[i][j+1] + self[j];
                else battle = dp[i+1][j+1];

                int discard =dp[i+1][j+1];

                dp[i][j] = Math.max(battle, discard);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A =  new int[N];
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(N, A, B));
    }
}
