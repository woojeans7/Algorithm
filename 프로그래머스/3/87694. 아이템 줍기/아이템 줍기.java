import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 사각형이 배치되어있음.
        // 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리를 구하는 문제
        // 겉 테두리를 따라서 이동할 수 있음. 겉 테두리에 대해 bfs 탐색
        int size = 102;
        int[][] board = new int[size][size];

        // board 초기화
        // 테두리만 1로 표시하고, 나머지는 -1 표시
        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    if(x == x1 || x == x2 || y == y1 || y == y2) {
                        // 테두리는 아직 아무 표시가 없을 때만 1로 표시
                        if(board[x][y] == 0) board[x][y] = 1;
                    }
                    else board[x][y] = -1;   // 내부는 -1로 덮어쓰기
                }
            }
        }

        int sx = characterX * 2, sy = characterY * 2;
        int ex = itemX * 2, ey = itemY * 2;

        // 시작점 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[size][size];
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] cur =  queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];

            if(row == ex && col == ey)  return dist / 2;

            for(int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < size && nc >= 0 && nc < size && !visited[nr][nc]) {
                    if(board[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}