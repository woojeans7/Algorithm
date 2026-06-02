import java.io.*;
import java.util.*;

public class Main {
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int m, int[][] points) {
        boolean[] selected = new boolean[n];
        backtrack(0,0, m, selected, points);
        return answer;
    }
    private void backtrack(int start, int depth, int m, boolean[] selected, int[][] points){
        if(depth == m){
            int max = 0;
            for(int i = 0; i < points.length; i++){
                if(!selected[i]) continue;
                for(int j = i + 1; j < points.length; j++){
                    if(!selected[j]) continue;
                    max = Math.max(max, euclideanDistance(points[i][0], points[i][1], points[j][0], points[j][1]));
                }
            }
            answer = Math.min(answer, max);
            return;
        }

        for(int i = start; i < points.length; i++){
            selected[i] = true;
            backtrack(i+1, depth+1, m, selected, points);
            selected[i] = false;
        }
    }
    private int euclideanDistance(int x1, int y1, int x2, int y2) {
        int xDiff = (x1 - x2) * (x1 - x2);
        int yDiff = (y1 - y2) * (y1 - y2);

        return xDiff + yDiff;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, M, points));
    }
}
