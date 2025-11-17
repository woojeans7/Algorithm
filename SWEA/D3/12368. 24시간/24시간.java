import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            int time = A + B;
            if(time < 24){
                sb.append("#"+ t).append(" " + time + "\n");
            }
            else{
                time -= 24;
                sb.append("#"+ t).append(" " + time + "\n");
            }
        }
        System.out.print(sb);
    }
}
