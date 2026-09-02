import java.io.*;
import java.util.*;

public class Main {
    public long solution(long n, long m) {
        long answer = 0;

        long left = 1;
        long right = n * n;

        while(left <= right) {
            long mid = (left + right) / 2;

            if(canPlace(n, m, mid)){
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return answer;
    }
    private boolean canPlace(long n, long m, long param){
        long count = 0;
        // n x n 배열에 속해있으면서, 몇 번째 안에 올 수 있는지 카운팅
        for(long i = 1; i <= n; i++){
            count += Math.min(param / i, n);
        }
        return count >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long M = Long.parseLong(br.readLine());

        Main main = new Main();
        System.out.println(main.solution(N, M));
    }
}
