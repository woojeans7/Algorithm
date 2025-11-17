import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++){
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            int d = 0;

            int N = Integer.parseInt(br.readLine());

            int[][] snail = new int[N][N];
            int r = 0;
            int c = 0;
            int cnt = 1;

            snail[0][0] = 1;
            for(int i = 2; i <= N*N; i++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && snail[nr][nc] == 0){
                    snail[nr][nc] = ++cnt;
                    r = nr;
                    c = nc;
                }
                else{
                    d = (d+1) % 4;
                    i--;
                }
            }

            sb.append("#" + t + "\n");


            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    sb.append(snail[i][j]);
                    if(j < N-1) sb.append(" ");
                }
                sb.append("\n");
            }


        }
            System.out.println(sb);
    }
}
