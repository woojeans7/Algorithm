import java.util.*;

public class Main {
    static int N;
    static int[] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        seq = new int[N];
        
        backtrack(0);
    }

    static boolean backtrack(int idx) {
        if (idx == N) {
            // 출력
            StringBuilder sb = new StringBuilder();
            for (int x : seq) sb.append(x);
            System.out.println(sb);
            return true;
        }

        for (int num : new int[]{4, 5, 6}) {
            seq[idx] = num;
            if (isValid(idx)) {
                if (backtrack(idx + 1)) return true;
            }
        }
        return false;
    }

    // idx번 인덱스까지 채운 상태에서 유효한지 확인
    // 끝부분에서 길이 k인 두 인접 부분수열 비교
    static boolean isValid(int idx) {
        int len = idx + 1;
        for (int k = 1; k * 2 <= len; k++) {
            boolean same = true;
            for (int i = 0; i < k; i++) {
                if (seq[idx - i] != seq[idx - k - i]) {
                    same = false;
                    break;
                }
            }
            if (same) return false;
        }
        return true;
    }
}