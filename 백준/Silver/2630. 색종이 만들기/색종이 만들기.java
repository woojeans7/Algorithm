import java.util.*;
import java.io.*;

/*
    BAEKJOON 2630번 색종이 만들기
    https://www.acmicpc.net/problem/2630
*/

public class Main {
    static int[][] paper;
    static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(N, 0 ,0);
        for(int i = 0; i < 2; i++){
            System.out.println(answer[i]);
        }
    }
    public static void divide(int n, int x, int y){
        if(check(n, x, y)){
            answer[paper[x][y]]++;
            return;
        }
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                divide(n / 2, x + i * n / 2, y + j * n / 2);
            }
        }
    }
    public static boolean check(int n, int x, int y){
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(paper[i][j] != paper[x][y]) return false;
            }
        }
        return true;
    }
}
