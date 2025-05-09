class Solution {
    static int m;
    static int n;
    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && (grid[i][j] == '1')) {
                    dfs(i,j, grid, visited);
                    cnt++;
                    System.out.println(i+","+j+"="+cnt);
                }
            }
        }
        return cnt;
    }
    public static boolean isValid(int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }

    public static void dfs(int curRow, int curCol, char[][] grid, boolean[][] visited){
        visited[curRow][curCol] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++){
            int nextRow = curRow + dr[i];
            int nextCol = curCol + dc[i];
            if(isValid(nextRow, nextCol)){
                if(!visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1'){
                    dfs(nextRow, nextCol, grid, visited);
                }
            }
        }

    }
}