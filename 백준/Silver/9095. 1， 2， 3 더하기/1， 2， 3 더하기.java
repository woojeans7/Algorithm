import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N =  Integer.parseInt(br.readLine());

            int[] dp = new int[N];

            if(N >= 3){
                dp[0] = 1;
                dp[1] = 2;
                dp[2] = 4;
                for(int j = 3; j < N; j++){
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
                }
                System.out.println(dp[N-1]);
            }
            else System.out.println(N);

        }
    }
}
