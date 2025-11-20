import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String ram =  br.readLine();

            char current = '0';
            int answer = 0;

            for(int i = 0; i < ram.length(); i++){
                if(current != ram.charAt(i)){
                    current = ram.charAt(i);
                    answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);

        }
    }
}
