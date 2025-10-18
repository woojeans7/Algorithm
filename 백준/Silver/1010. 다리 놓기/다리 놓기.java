import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws  IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int k = Integer.parseInt(st.nextToken());
      int result = 0;

      for(int i = 0; i < k; i++){
          st = new StringTokenizer(br.readLine());
          int M = Integer.parseInt(st.nextToken());
          int N = Integer.parseInt(st.nextToken());

          result = combination(N, M);
          System.out.println(result);

      }

  }
  public static int[][] dp = new int[30][30];

  private static int combination(int n, int r) {
      if(dp[n][r] > 0) return dp[n][r];

      if (n == r || r == 0) return dp[n][r] = 1;

      return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
  }
}
