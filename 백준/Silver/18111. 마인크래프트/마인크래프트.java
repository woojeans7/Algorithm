import java.util.*;
import java.io.*;

/*
    BAEKJOON 18111번 마인크래프트
    https://www.acmicpc.net/problem/18111
*/

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        int height = 0;

        for(int h = 256; h >= 0; h--) {
            int remove = 0;
            int put = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] > h){
                       remove += (map[i][j] - h);
                    }
                    else if(map[i][j] < h){
                        put += (h - map[i][j]);
                    }
                }
            }

            if((remove + B) >= put){
                int time = remove * 2 + put;

                if(time < min){
                    min = time;
                    height = h;
                }
            }
        }

        System.out.println(min + " " + height);
    }
}
