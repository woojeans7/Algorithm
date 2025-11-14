import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] wire = new int[K];
        long max = 0;
        for(int i = 0; i < K; i++){
            wire[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, wire[i]);
        }

        long left = 1;
        long right = max;
        long ans = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            // mid 길이로 잘랐을  만들 수 있는 선의 수
            long count = 0;
            for(int i = 0; i < K; i++){
                count += wire[i] / mid;
            }

            // 선의 개수가 N보다 크면 만족
            if(count >= N){
                ans = mid;
                left = mid + 1; // 더 길이가 클 수 있으니 더 탐색
            }
            else{
                right = mid - 1; // N개 미만이면 길이를 줄여봄
            }
        }

        System.out.println(ans);
    }
}
