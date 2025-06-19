import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 보드 만들기
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        // 가능한 정답을 저장하는 리스트
        List<List<String>> res = new ArrayList<>();

        // 각 행에 대한 열 인덱스를 저장
        int[] index = new int[n];

        // 백트래킹
        dfs(0,n,res, board);

        // 말을 놓을 수 있는지 조건 체크


        return res;
    }

    private void dfs(int row, int n, List<List<String>> res, char[][] board){
        if(row == n){
            res.add(makeBoard(board));
            return;
        }
        for(int col=0; col<n; col++){
            if(isValid(row, col, board)){
                board[row][col] = 'Q';
                dfs(row+1, n, res, board);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] board){
        // 열 탐색 -> 같은 열에 둘 수 없음.
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // 대각선 탐색
        int i = row - 1;
        int j = col - 1;

        while( i >= 0 && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < board.length){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }

    private List<String> makeBoard(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row: board){
            list.add(new String(row));
        }
        return list;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> res = sol.solveNQueens(4);
        System.out.println(res);
    }
}