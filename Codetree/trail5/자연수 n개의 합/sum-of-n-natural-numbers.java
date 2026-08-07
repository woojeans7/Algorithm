import java.io.*;
import java.util.*;

public class Main {
    public long solution(long s) {
        long answer = 0;

        long left = 1;
        long right = s;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid <= (2 * s) / (mid + 1)) {
                answer = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long S = Long.parseLong(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(S));
    }
}
