class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][];
        for (int i = 0; i < n; i++) {
            snail[i] = new int[i + 1];
        }

        // 3방향: 하, 우, 대각선 위(↖)
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};

        int r = 0, c = 0, d = 0;
        for (int num = 1; num <= n * (n + 1) / 2; num++) {
            snail[r][c] = num;

            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 초과 또는 이미 채워진 경우 방향 전환
            boolean outOfBounds = nr < 0 || nr >= n || nc < 0 || nc >= snail[nr].length;
            boolean alreadyFilled = !outOfBounds && snail[nr][nc] != 0;

            if (outOfBounds || alreadyFilled) {
                d = (d + 1) % 3;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }

        // 행 순서대로 1차원 배열에 담기
        int[] result = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int[] row : snail) {
            for (int val : row) {
                result[idx++] = val;
            }
        }

        return result;
    }
}