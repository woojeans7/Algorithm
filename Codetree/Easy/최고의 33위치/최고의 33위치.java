import java.util.*;
import java.io.*;

/*
    Codetree 최고의 33위치
    https://www.codetree.ai/ko/trails/complete/curated-cards/intro-best-place-of-33/description
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i <= n-3; i++){
            for(int j = 0; j <= n-3; j++){
                int cnt = 0;
                for(int di = 0; di < 3; di++){
                    for(int dj = 0; dj < 3; dj++){
                        cnt += grid[i + di][j + dj];
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}
