import java.io.*;
import java.util.*;

public class Main {
    int n;
    int answer = Integer.MIN_VALUE;
    public int solution(int[][] grid) {
        n = grid.length;
        boolean[] selected = new boolean[n];
        dfs(0, selected, new ArrayList<>(), grid);
        return answer;
    }
    private void dfs(int row, boolean[] selected, List<Integer> cur, int[][] grid){
        if(row == n){
            int minVal = Integer.MAX_VALUE;
            for(int num : cur){
                minVal = Math.min(minVal, num);
            }
            answer = Math.max(answer, minVal);
            return;
        }
        for(int col = 0; col < n; col++){
            if(!selected[col]){
                selected[col] = true;
                cur.add(grid[row][col]);
                dfs(row+1, selected, cur, grid);
                selected[col] = false;
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A =  new int[N][N];
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
