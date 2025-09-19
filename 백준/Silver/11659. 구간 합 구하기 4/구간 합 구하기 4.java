import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[] sum = new int[N+1];
      st = new StringTokenizer(br.readLine());
      for(int i = 1; i <= N; i++){
          sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
      }

      for(int j = 0; j < M; j++){
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          System.out.println(sum[y]-sum[x-1]);
      }
	}
}
