import java.util.*;

class Solution {
    static int n;
    public static int solution(int[][] board) {
        n = board.length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][][] visited = new boolean[n][n][2]; // 수직, 수평 방향 추가

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r1 = cur[0], c1 = cur[1];
            int r2 = cur[2], c2 = cur[3];
            int dist = cur[4];


            // 도착하면 종료
            if ((r1 == n - 1 && c1 == n - 1) || (r2 == n - 1 && c2 == n - 1)) {
                return dist;
            }

            // 이동
            for (int d = 0; d < 4; d++) {
                int nr1 = r1 + dr[d], nc1 = c1 + dc[d];
                int nr2 = r2 + dr[d], nc2 = c2 + dc[d];

                // 유효성 검사
                if (isValid(nr1, nc1, board) && isValid(nr2, nc2, board)) {
                    int dir = (nc1 == nc2) ? 1 : 0; // 방향 체크
                    // 기준이 되는 좌표 설정 (더 왼쪽, 위쪽에 있는 좌표)
                    int br = Math.min(nr1, nr2);
                    int bc = Math.min(nc1, nc2);

                    // 작은 좌표를 기준으로 방문 처리 -> 방향에 따라서 같은 위치를 기준으로 방문을 일괄 처리하기 위해서
                    if (!visited[br][bc][dir]) {
                        visited[br][bc][dir] = true;
                        queue.offer(new int[]{nr1, nc1, nr2, nc2, dist + 1});
                    }
                }
            }

            // 회전 처리
            rotate(board, visited, queue, r1, c1, r2, c2, dist);
        }

        return -1;
    }

    // 유효성 체크
    private static boolean isValid(int r, int c, int[][] board) {
        // 이동 가능한지 (0), 범위를 벗어나는지
        return r >= 0 && c >= 0 && r < n && c < n && board[r][c] == 0;
    }

    // 회전 상태 구현
    private static void rotate(int[][] board, boolean[][][] visited, Queue<int[]> queue,
                               int r1, int c1, int r2, int c2, int dist) {
        // 수평 방향 = 가로 상태
        if (r1 == r2) {
            // 위쪽 회전
            if (isValid(r1 - 1, c1, board) && isValid(r2 - 1, c2, board)) {
                if (!visited[r1 - 1][c1][1]) {
                    visited[r1 - 1][c1][1] = true;
                    queue.offer(new int[]{r1 - 1, c1, r1, c1, dist + 1});
                }
                if (!visited[r2 - 1][c2][1]) {
                    visited[r2 - 1][c2][1] = true;
                    queue.offer(new int[]{r2 - 1, c2, r2, c2, dist + 1});
                }
            }
            // 아래쪽 회전
            if (isValid(r1 + 1, c1, board) && isValid(r2 + 1, c2, board)) {
                if (!visited[r1][c1][1]) {
                    visited[r1][c1][1] = true;
                    queue.offer(new int[]{r1, c1, r1 + 1, c1, dist + 1});
                }
                if (!visited[r2][c2][1]) {
                    visited[r2][c2][1] = true;
                    queue.offer(new int[]{r2, c2, r2 + 1, c2, dist + 1});
                }
            }
        }
        // 수직 방향 = 세로 상태
        else if (c1 == c2) {
            // 왼쪽 회전
            if (isValid(r1, c1 - 1, board) && isValid(r2, c2 - 1, board)) {
                if (!visited[r1][c1 - 1][0]) {
                    visited[r1][c1 - 1][0] = true;
                    queue.offer(new int[]{r1, c1 - 1, r1, c1, dist + 1});
                }
                if (!visited[r2][c2 - 1][0]) {
                    visited[r2][c2 - 1][0] = true;
                    queue.offer(new int[]{r2, c2 - 1, r2, c2, dist + 1});
                }
            }
            // 오른쪽 회전
            if (isValid(r1, c1 + 1, board) && isValid(r2, c2 + 1, board)) {
                if (!visited[r1][c1][0]) {
                    visited[r1][c1][0] = true;
                    queue.offer(new int[]{r1, c1, r1, c1 + 1, dist + 1});
                }
                if (!visited[r2][c2][0]) {
                    visited[r2][c2][0] = true;
                    queue.offer(new int[]{r2, c2, r2, c2 + 1, dist + 1});
                }
            }
        }
    }
}
