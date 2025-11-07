import java.util.*;
import java.io.*;

public class Main {
    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.y == o.y){
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(points[i].x + " " + points[i].y).append("\n");
        }
        System.out.println(sb);
    }
}

