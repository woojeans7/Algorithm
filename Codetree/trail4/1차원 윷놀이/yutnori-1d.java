import java.io.*;
import java.util.*;

public class Main {
    int n;
    int answer = 0;
    public int solution(int m, int k, int[] turns) {
        n = turns.length;
        int[] pos = new int[k];
        Arrays.fill(pos, 1);
        backtrack(0, 0, pos, turns, m, k);

        return answer;
    }
    private void backtrack(int idx, int score, int[] pos, int[] turns, int m, int k) {

        // n번의 턴이 흐르면 종료
        if (idx == n) {
            answer = Math.max(answer, score);
            return;
        }

        int move = turns[idx];
        boolean flag = false;

        // 말을 k까지 순서대로 선택 - 턴 순서대로 더하기
        for(int i = 0; i < k; i++){

            // 현재 말이 현재 턴만큼 더해서 위치 표시 -> pos + turn[idx]
            int before = pos[i];
            int after = Math.min(pos[i] + move, m);

            // 이미 도달한 말은 제외
            if(before == m) continue;
            flag = true;

            int gained = (after == m) ? 1 : 0;

            pos[i] = after;
            backtrack(idx + 1, score + gained, pos, turns, m, k);
            pos[i] = before; // 다른 말을 움직이는 경우 백트래킹
        }

        if(!flag) backtrack(idx + 1, score, pos, turns, m, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Main main = new Main();
        System.out.println(main.solution(M, K, A));
    }
}
