import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] nums) {
        int[] lis = new int[n];
        int[] lds = new int[n];

        // ─── LIS (왼→오) ───────────────────────────────
        // tails[i]: 길이 i+1인 증가 부분수열의 마지막 원소 최솟값
        List<Integer> tails = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(tails, nums[i]); // 같은 값 허용 X → strictly increasing
            if (pos == tails.size()) tails.add(nums[i]);
            else tails.set(pos, nums[i]);
            lis[i] = pos + 1;
        }

        // ─── LDS (오→왼, 즉 역방향 LIS) ────────────────
        tails.clear();
        for (int i = n - 1; i >= 0; i--) {
            int pos = lowerBound(tails, nums[i]);
            if (pos == tails.size()) tails.add(nums[i]);
            else tails.set(pos, nums[i]);
            lds[i] = pos + 1;
        }

        // ─── 각 꼭짓점 k에 대해 lis[k] + lds[k] - 1 최대 ──
        int answer = 0;
        for (int k = 0; k < n; k++) {
            answer = Math.max(answer, lis[k] + lds[k] - 1);
        }
        return answer;
    }

    // tails 에서 target 이상인 첫 번째 위치 (lower_bound)
    private int lowerBound(List<Integer> tails, int target) {
        int lo = 0, hi = tails.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (tails.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
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
