import java.io.*;
import java.util.*;

public class Main {
    int answer = Integer.MAX_VALUE;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(char[][] board, int[][] pos) {
        int n = board.length;

        int[][] nums = new int[10][2];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'S' || board[i][j] == 'E' || board[i][j] == '.') continue;
                int k = board[i][j] - '0';
                nums[k][0] = i;
                nums[k][1] = j;
                list.add(k);
            }
        }

        list.sort(Comparator.comparingInt(o -> o));

        // backtracking으로 3개 순서 뽑기
        backtrack(0, 0, nums, list, new ArrayList<>(), board, pos);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    // k 중 3개 뽑아서 해당 위치를 구하면서 bfs
    private void backtrack(int depth, int start, int[][] nums, List<Integer> list, List<int[]> cur,char[][] board, int[][] pos){
        if(depth == 3){
            int res = bfs(board, pos[0], cur.get(0));
            for(int i = 0; i < cur.size() - 1; i++){
                res += bfs(board, cur.get(i), cur.get(i+1));
            }
            res += bfs(board, cur.get(cur.size()-1), pos[1]);

            answer = Math.min(answer, res);
            return;
        }

        for(int i = start; i < list.size(); i++){
            cur.add(nums[list.get(i)]);
            backtrack(depth + 1, i + 1, nums, list, cur, board, pos);
            cur.remove(cur.size() - 1);
        }

    }

    private int bfs(char[][] board, int[] start, int[] end){

        int n = board.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[n][n];
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            if(row == end[0] && col == end[1]) return dist;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(!visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char[][] A = new char[N][N];
        int[][] P = new int[2][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] row = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                A[i][j] = row[j];
                if(A[i][j] == 'S'){
                    P[0] = new int[]{i,j};
                }
                else if(A[i][j] == 'E'){
                    P[1] = new int[]{i,j};
                }
            }
        }

        Main main = new Main();
        System.out.println(main.solution(A, P));
    }
}
