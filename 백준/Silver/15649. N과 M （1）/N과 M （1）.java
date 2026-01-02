import java.util.*;
import java.io.*;

/*
    BAEKJOON 15649번 N과 M (1)
    https://www.acmicpc.net/problem/15649
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        List<List<Integer>> result = permute(N, M);
        for (List<Integer> p : result) {
            for(Integer i : p) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static List<List<Integer>> permute(int n, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];  // 1부터 n까지 숫자를 사용하기 위해 크기를 n+1로 설정
        backtrack(n, r, new ArrayList<>(), visited, ans);
        return ans;
    }

    private static void backtrack(int n, int r, List<Integer> curr, boolean[] visited, List<List<Integer>> ans) {
        if (curr.size() == r) {
            ans.add(new ArrayList<>(curr));  // 정답 저장
            return;
        }

        for (int i = 1; i <= n; i++) {  // 1부터 n까지 숫자 직접 사용
            if (!visited[i]) {  // 방문하지 않은 숫자만 선택
                curr.add(i);
                visited[i] = true;
                backtrack(n, r, curr, visited, ans);
                curr.remove(curr.size() - 1);  // Backtracking: 원래 상태로 되돌리기
                visited[i] = false;  // 방문 체크 해제
            }
        }
    }
}
