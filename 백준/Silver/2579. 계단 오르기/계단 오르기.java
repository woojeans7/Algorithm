import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] stairs = new int[n];
        for(int i = 0; i < n; i++){
            stairs[i] = sc.nextInt();
        }
        if(n == 1) {
            System.out.println(stairs[0]);
            return;
        }
        else if(n == 2) {
            System.out.println(stairs[1] + stairs[0]);
            return;
        }

        int[] dp = new int[n];
        dp[0] = stairs[0];
        dp[1] = stairs[0]+ stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        for(int i = 3; i < n; i++){
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
            //System.out.println("dp[" + i + "] = " + dp[i]);
        }

        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[n-1]);
    }
}
