import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n =  Integer.parseInt(st.nextToken());

      Points[] points = new Points[n];

      for (int i = 0; i < n; i++) {
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          points[i] = new Points(x, y);
      }

      Arrays.sort(points);

      StringBuilder sb = new StringBuilder();
      for (Points p : points) {
          sb.append(p.x).append(" ").append(p.y).append("\n");
      }
      System.out.print(sb);
  }
}

class Points implements Comparable<Points>{
    int x;
    int y;

    public Points(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Points o) {
        if(this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}