import java.io.*;
import java.util.*;

public class Main {
    int answer = Integer.MAX_VALUE;
    public int solution(int n, int[] nums) {

        backtrack(0, n, nums, new ArrayList<>());
        return answer;
    }
    // 2n개 중에 2개를 선택하고 나머지 그룹을 구함 (순서 상관 X -> 조합)
    private void backtrack(int start, int n, int[] nums, List<Integer> cur){
        if(cur.size() == n){
            Set<Integer> set = new HashSet<>(cur);
            int sumA = 0, sumB = 0;
            for(int i = 0; i < 2 * n; i++){
                if(set.contains(i)) sumA += nums[i];
                else sumB += nums[i];
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));
            return;
        }

        for(int i = start; i < 2 * n; i++){
            cur.add(i);
            backtrack(i + 1, n, nums, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Main main = new Main();
        System.out.println(main.solution(N, A));
    }
}
