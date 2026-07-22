import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int length = 0;
        for(int right = 0; right < n; right++){
            int num = nums[right];

            if(map.containsKey(num)){
                left = Math.max(left, map.getOrDefault(num, -1) + 1);
            }

            map.put(num, right);

            length = Math.max(length, right - left + 1);
        }

        return length;
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
