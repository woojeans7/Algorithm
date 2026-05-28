import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int m, int[] e, int[] t) {
        int total = 0;
        for(int i = 0; i < n; i++) total += e[i];

        int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[total + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = total; j >= e[i]; j--){
                if(dp[j - e[i]] != INF){
                    dp[j] = Math.min(dp[j], dp[j - e[i]] + t[i]);
                }
            }
        }

        int ans = INF;
        for(int j = m; j <= total; j++){
            ans = Math.min(ans, dp[j]);
        }

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] E = new int[N];
        int[] T = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            E[i] = Integer.parseInt(st.nextToken());
            T[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, M, E, T));
    }
}
