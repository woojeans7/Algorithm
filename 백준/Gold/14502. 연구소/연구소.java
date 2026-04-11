import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //✅ 입력 형식에 맞춰 입력값을 받는다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int M = Integer.parseInt(line[1]);
        //✅ 빈 칸과 바이러스 위치를 저장한다.
        List<Point> poison = new ArrayList<>();
        Set<Point> wall = new HashSet<>();
        List<Point> empty = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            String[] s = reader.readLine().split(" ");
            for (int c = 0; c < M; c++) {
                switch (s[c]) {
                    case "0": empty.add(new Point(r, c)); break;
                    case "1": wall.add(new Point(r, c)); break;
                    case "2": poison.add(new Point(r, c)); break;
                }
            }
        }
        // BFS로 구현했지만, DFS로 구현해도 된다. 
        // DFS(재귀)로 구현해보면 조금 복잡해지는게 생긴다.

        // BFS는 Queue<Point> queue = new ArrayDeque<>(poison)를 이용해서 
        // 여러 바이러스를 동시에 확산시킬 수 있는데, DFS로 구현하면 DFS를 여러번 호출해야되서 번거로워진다.

        int minPoison = Integer.MAX_VALUE;
        //✅ 임의의 3개의 빈 칸을 선택한다.
        List<List<Point>> combList = combination(empty, 3);
        for (List<Point> comb : combList) {
	        //✅ 선택한 3개의 빈 칸에 벽을 세운다.
            comb.forEach(p -> wall.add(p));
	        //✅ 바이러스 위치를 시작으로 BFS/DFS 알고리즘을 수행한다.
	        //✅ 안전영역의 최대 넓이를 갱신한다.
            minPoison = Math.min(minPoison, bfs(poison, wall, N, M));
	        //✅ 세웠던 3개의 벽을 다시 빈 칸으로 되돌린다.
            comb.forEach(p -> wall.remove(p));
        }

        System.out.println(N * M - minPoison - wall.size() - 3);
    }

    static int bfs(List<Point> poison, Set<Point> wall, int N, int M) {
        int[] dr = {  0, -1,  0,  1 };
        int[] dc = { -1,  0,  1,  0 };

        Queue<Point> queue = new ArrayDeque<>(poison);
        Set<Point> visited = new HashSet<>(poison);
        int count = poison.size();
        while (!queue.isEmpty()) {
            Point cur = queue.remove();

            for (int i = 0; i < 4; i++) {
                Point next = new Point(cur.r + dr[i], cur.c + dc[i]);
                if (next.inRange(N, M) && !visited.contains(next) && !wall.contains(next)) {
                    count++;
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return count;
    }

    static List<List<Point>> combination(List<Point> points, int count) {
        List<List<Point>> result = new ArrayList<>();
        combination_inner(points, new ArrayList<>(), result, count, 0);
        return result;
    }

    static void combination_inner(List<Point> points, List<Point> pick, List<List<Point>> result, int count, int start) {
        if (pick.size() == count) {
            result.add(new ArrayList<>(pick));
            return;
        }

        for (int i = start; i < points.size(); i++) {
            pick.add(points.get(i));
            combination_inner(points, pick, result, count, i + 1);
            pick.remove(pick.size() - 1);
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean inRange(int n, int m) {
            return r >= 0 && r < n && c >= 0 && c < m;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point)o;
                return this.r == p.r && this.c == p.c;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + ")";
        }
    }
}