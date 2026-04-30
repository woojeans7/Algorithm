import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[][] grid){
        int answer = 0;

        // 우상, 좌상, 좌하, 우하
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int a = 1; a <= n; a++){
                    for(int b = 1; b <= n; b++){
                        int cx = i, cy = j;
                        int sum = 0;
                        boolean flag = true;

                        int[] moves = {a, b, a, b};
                        for(int d = 0; d < 4; d++){
                            for(int k = 0; k < moves[d]; k++){
                                cx += dx[d];
                                cy += dy[d];

                                if(!isValid(cx, cy, n)) {
                                    flag = false;
                                    break;
                                }

                                sum += grid[cx][cy];
                            }

                            if(!flag) break;

                        }

                        if(flag) answer = Math.max(answer, sum);

                    }
                }
            }
        }

        return answer;
    }
    private boolean isValid(int r, int c, int n){
        return 0 <= r && r < n &&  0 <= c && c < n;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(T.solution(N, grid));
    }
}
