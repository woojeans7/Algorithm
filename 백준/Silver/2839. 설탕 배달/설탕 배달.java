import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        int[] dp = new int[N+1];
        Arrays.fill(dp, N+1);
        dp[3] = 1;
        if(N >= 5) dp[5] = 1;

        int[] sugar = new int[]{3,5};

        for(int i = 6; i <= N; i++) {
            for(int s : sugar){
                dp[i] = Math.min(dp[i], dp[i-s] + 1);
            }
        }

        int answer = dp[N] < N+1 ?  dp[N] : -1;
        System.out.println(answer);
    }
}