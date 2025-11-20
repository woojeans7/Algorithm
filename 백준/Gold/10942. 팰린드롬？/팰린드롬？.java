import java.util.*;
import java.io.*;

/*
    BAEKJOON 10942번 팰린드롬?
    https://www.acmicpc.net/problem/10942
*/

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][N+1];

        for(int len = 1 ; len <= N; len++){
            for(int s = 1; s + len - 1 <= N; s++){
                int e = s + len - 1;
                dp[s][e] = isPalindrome(nums, s, e);
            }
        }

        int M =  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end] + "\n");
        }

        System.out.println(sb);
    }
    public static int isPalindrome(int[] nums, int s, int e) {
        while (s < e) {
            if(nums[s] != nums[e]) return 0;
            s++;
            e--;
        }
        return 1;
    }
}
