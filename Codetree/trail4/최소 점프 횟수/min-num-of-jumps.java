import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] nums) {
        if(n == 1) return 0;

        int jumps = 0;
        int curEnd = 0;
        int max = 0;

        for(int i = 0; i < n - 1; i++){
            max = Math.max(max, i + nums[i]);

            if(max >= n - 1) return jumps + 1;

            if(i == curEnd){
                if(max == curEnd) return -1;
                jumps++;
                curEnd = max;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, A));
    }
}
