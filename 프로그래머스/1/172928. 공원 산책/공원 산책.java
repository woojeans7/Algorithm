import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    Map<Character, Integer> map = new HashMap<>();

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        map.put('N', 0);
        map.put('S', 1);
        map.put('W', 2);
        map.put('E', 3);

        char[][] grid = new char[park.length][];
        for(int i = 0; i < park.length; i++){
            grid[i] = park[i].toCharArray();
        }

        int n = grid.length;
        int m = grid[0].length;

        int si = 0, sj = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'S'){
                    si = i;
                    sj = j;
                }
            }
        }

        // 명령만큼
        for(String c : routes){
            String[] command = c.split(" ");
            char dir = command[0].charAt(0);
            int pos = Integer.parseInt(command[1]);

            int d = map.get(dir);

            int nr = si,  nc = sj;
            for(int i = 0; i < pos; i++){
                nr += dr[d];
                nc += dc[d];

                // 조건 검사
                if(nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] == 'X'){
                    break;
                }
            }

            if(nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] == 'X'){

                continue;
            }

            // 위치 갱신
            si = nr;
            sj = nc;
        }


        return new int[]{si,sj};
    }
}