import java.util.*;
import java.io.*;

/*
    BAEKJOON 3190번 뱀
    https://www.acmicpc.net/problem/3190
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int K  = Integer.parseInt(br.readLine());

        int[][] board = new int[N+1][N+1];
        Arrays.fill(board[0], -1);
        for(int i = 0; i < N+1; i++) {
            board[i][0] = -1;
        }

        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        int[] change = new int[L];
        char[] direction = new char[L];
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);

            change[i] = X;
            direction[i] = C;
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{1, 1});
        board[1][1] = 1;

        int[] dr = new int[]{0, 1, 0, -1}; // 우, 하, 좌, 상
        int[] dc = new int[]{1, 0, -1, 0};

        int state = 0; // 초기 방향 : 오른쪽
        int time = 0;
        int l = 0;
        while(true) {
            time++;

            int[] head = snake.peekLast();

            int row = head[0];
            int col = head[1];

            int nr = row + dr[state];
            int nc = col + dc[state];

            // 벽 충돌 체크
            if(nr < 1 || nr > N || nc < 1 || nc > N) {
                System.out.println(time);
                return;
            }

            // 자기 몸 충돌 체크
            if(board[nr][nc] == 1) {
                System.out.println(time);
                return;
            }

            // 사과가 아니면 꼬리 제거
            if(board[nr][nc] == 0) {
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0;
            }

            // 머리 이동
            snake.offer(new int[]{nr, nc});
            board[nr][nc] = 1;

            // 방향 전환 체크
            if(l < L && time == change[l]) {
                if(direction[l] == 'L') {
                    state = (state + 3) % 4; // 좌회전
                } else {
                    state = (state + 1) % 4; // 우회전
                }
                l++;
            }
        }
    }
}
