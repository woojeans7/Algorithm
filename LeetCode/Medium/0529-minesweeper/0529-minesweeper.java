import java.util.*;

class Solution {
    static int m;
    static int n;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;

        // 8방향 탐색
        int[] dr = {-1,1,0,0,-1,-1,1,1};
        int[] dc = {0,0,-1,1,-1,1,-1,1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(click);

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            // 지뢰면 종료
            if(board[r][c] == 'M'){
                board[r][c] = 'X';
                break;
            }

            // 지뢰 개수
            int mine = 0;
            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(isValid(nr, nc)){
                    if(board[nr][nc] == 'M') mine++;
                }
            }
            if(mine == 0){
                board[r][c] = 'B';
                for(int i = 0; i < 8; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(isValid(nr, nc) && board[nr][nc] == 'E'){
                        queue.offer(new int[]{nr, nc});
                        board[nr][nc] = '0';
                    }
                }
            }
            else{
                board[r][c] = (char)('0' + mine);
            }

        }


        return board;
    }

    boolean isValid(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}