import java.io.*;
import java.util.*;

public class Main {
    public void solution(long m, long a, long b) {

        long min = Long.MAX_VALUE;
        long max = 0;
        for(long i = a; i <= b; i++) {
            long count = binarySearch(m, i);
            min = Math.min(count, min);
            max = Math.max(max, count);
        }

        System.out.println(min + " " + max);

    }
    private long binarySearch(long m, long target) {
        long count = 0;

        long left = 1;
        long right = m;
        // 1부터 m까지 반복
        while (left <= right) {
            count ++; // 턴을 세기

            long mid = (left + right) / 2;

            // 정답 찾으면
            if(target == mid) break;
            else if(target > mid) {
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long M = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Main main = new Main();
        main.solution(M, A, B);
    }
}
