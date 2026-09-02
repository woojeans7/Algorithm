import java.io.*;
import java.util.*;

public class Main {
    public long solution(long n) {
        long answer = 0;

        long low = 1, high = n * 2;

        while (low <= high) {
            long mid = (low + high) / 2;

            if(countUpTo(n, mid)){
                answer = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return answer;
    }
    private boolean countUpTo(long n, long param){
        long count = param - (param / 3 + param / 5 - param / 15);
        return count >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(N));
    }
}
