import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int k, int[] nums) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int complement = k - num;
            if(map.containsKey(complement)){
                answer += map.get(complement);
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums =  new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, K, nums));
    }
}
