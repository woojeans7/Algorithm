import java.io.*;
import java.util.*;

public class Main {
    int n;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] cost) {
        n = cost.length;
        boolean[] visited = new boolean[n];
        visited[0] = true;

        backtrack(1, 0, 0, cost, visited, 0);

        return answer;
    }
    private void backtrack(int depth, int cur, int start, int[][] cost, boolean[] visited, int total){
        if(depth == n){
            if(cost[cur][start] != 0){
                answer = Math.min(answer, total + cost[cur][start]);
            }
            return;
        }

        for(int next = 0; next < n; next++){
            if(!visited[next] && cost[cur][next] != 0){
                visited[next] = true;
                backtrack(depth + 1, next, start, cost, visited, total + cost[cur][next]);
                visited[next] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
