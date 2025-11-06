import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean start = inCircle(x1, y1, cx, cy, r);
                boolean end = inCircle(x2, y2, cx, cy, r);

                if(start != end) count++;
            }
            System.out.println(count);
        }
    }
    public static boolean inCircle(int x, int y, int cx, int cy, int r){
        int dx = x - cx;
        int dy = y - cy;
        return  dx * dx + dy * dy < r*r;
    }
}
