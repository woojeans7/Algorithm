import java.io.*;
import java.util.*;

public class Main {
    int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] p) {
        backtrack(1, n, p, new ArrayList<>());
        return answer;
    }
    private void backtrack(int start, int n, int[][] p, List<Integer> cur) {
        // n/2까지 선택
        if (cur.size() == n / 2){
            // 업무 강도 계산
            int intensity = calc(n, p, cur);
            answer = Math.min(answer, intensity);
            return;
        }

        for(int i = start; i <= n; i++){
            cur.add(i);
            backtrack(i + 1, n, p, cur);
            cur.remove(cur.size() - 1);
        }

    }
    private int calc(int n, int[][] p, List<Integer> morning) {
        List<Integer> evening = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(!morning.contains(i)){
                evening.add(i);
            }
        }

        int morningSum = 0;
        for(int i : morning) {
            for (int j : morning) {
                if (i == j) continue;
                morningSum += p[i - 1][j - 1];
            }
        }

        int eveningSum = 0;
        for(int i : evening){
            for(int j : evening){
                if(i == j) continue;
                eveningSum += p[i-1][j-1];
            }
        }

        return Math.abs(eveningSum - morningSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] P =  new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                P[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(N, P));
    }
}
