    import java.util.*;

    class Solution {
        public boolean exist(char[][] board, String word) {
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == word.charAt(0)){
                        if(dfs(board, word, i, j, 0)) return true;
                    }
                }
            }

            return false;
        }

        public boolean dfs(char[][] board, String word, int r, int c, int idx){

            if (idx == word.length() - 1) return board[r][c] == word.charAt(idx);

            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};

            char temp = board[r][c];
            board[r][c] = '#';

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length
                        && board[nr][nc] == word.charAt(idx + 1)) {
        
                    if (dfs(board, word, nr, nc, idx + 1)) return true;
                }
            }
            board[r][c] = temp;
            
            return false;
        }

    }