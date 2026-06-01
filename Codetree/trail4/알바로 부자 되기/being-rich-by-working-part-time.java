import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] s, int[] e, int[] p) {

        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = p[i];
            for(int j = 0; j < i; j++){
                if(e[j] < s[i]){
                    dp[i] = Math.max(dp[i], dp[j] + p[i]);
                }
            }
        }

        int answer = 0;
        for (int val : dp) {
            answer = Math.max(answer, val);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] S = new int[N];
        int[] E = new int[N];
        int[] P = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            E[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, S, E, P));
    }
}
