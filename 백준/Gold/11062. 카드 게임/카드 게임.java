import java.util.*;
import java.io.*;

/*
    BAEKJOON 11062번 카드 게임
    https://www.acmicpc.net/problem/11062
*/

public class Main {
    static int[][] dp;
    static int[][] sum;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new  StringBuilder();

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());

            cards = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                cards[j] = Integer.parseInt(st.nextToken());
            }

            // 현재 차례인 사람이 얻을 수 있는 최대 점수
            dp = new int[N][N];
            for(int i = 0; i < N; i++) {
                Arrays.fill(dp[i], -1);
            }

            // 구간 합 계산
            sum = new int[N][N];
            for(int i = 0; i < N; i++) {
                sum[i][i] = cards[i];
                for(int j = i + 1; j < N; j++) {
                    sum[i][j] = sum[i][j-1] + cards[j];
                }
            }

            int answer = game(0, N-1);
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
    public static int game(int l, int r){
        if(l > r) return 0;
        if(l == r) return cards[l];
        if(dp[l][r] != -1) return dp[l][r];

        // 왼쪽 선택
        int pickLeft = cards[l];
        if(l+1 <= r) {
            pickLeft += sum[l+1][r] - game(l+1, r);
        }

        // 오른쪽 선택
        int pickRight = cards[r];
        if(l <= r-1) {
            pickRight += sum[l][r-1] - game(l, r-1);
        }

        return dp[l][r] = Math.max(pickLeft, pickRight);
    }

}
