import java.util.*;
import java.io.*;

/*
    BAEKJOON 1018번 체스판 다시 칠하기
    https://www.acmicpc.net/problem/1018
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] board = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                int count = checkPattern(board, i, j);

                min = Math.min(min, count);
            }
        }

        System.out.println(min);
    }
    private static int checkPattern(String[] board, int row, int col) {
        int count = 0;

        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                char cur = board[row+i].charAt(col+k);

                if((i+k) % 2 == 0){
                    if(cur == 'B') count++;
                }
                else{
                    if(cur == 'W') count++;
                }
            }
        }

        return Math.min(count, 64-count);
    }
}
